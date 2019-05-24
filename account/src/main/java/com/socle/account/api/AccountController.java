package com.socle.account.api;

import com.socle.account.connectors.CardProxyConnector;
import com.socle.account.domains.Account;
import com.socle.account.dtos.Carte;
import com.socle.account.repositories.AccountRepositorie;
import com.socle.commons.exceptions.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Account Management System", description = "Operations pertaining to account in Account Management System")
public class AccountController {
    @Autowired
    private AccountRepositorie accountRepositorie;

    @Autowired
    CardProxyConnector cardProxyConnector;

    @ApiOperation(value = "View a list of available accounts", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Carte> cartes = cardProxyConnector.getAllCustomers();
        return accountRepositorie.findAll();
    }

    @GetMapping("/cartes")
    public List<Carte> getAllAccountsCards() {
        return cardProxyConnector.getAllCustomers();
    }
    
    @ApiOperation(value = "Get an account by Id")
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(
            @ApiParam(value = "Account id from which account object will retrieve", required = true) @PathVariable(value = "id") Long accountId)
            throws ResourceNotFoundException {
        Account account = accountRepositorie.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
        return ResponseEntity.ok().body(account);
    }

    @ApiOperation(value = "Add an accounts")
    @PostMapping("/accounts")
    public Account createAccount(
            @ApiParam(value = "Account object store in database table", required = true) @Valid @RequestBody Account account) {
        return accountRepositorie.save(account);
    }

    @ApiOperation(value = "Update an account")
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(
            @ApiParam(value = "Account Id to update account object", required = true) @PathVariable(value = "id") Long accountId,
            @ApiParam(value = "Update account object", required = true) @Valid @RequestBody Account accountDetails) throws ResourceNotFoundException {
        Account account = accountRepositorie.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
        account.setId(accountDetails.getId());
        account.setNumber(accountDetails.getNumber());
        account.setType(accountDetails.getType());
        final Account updatedAccount = accountRepositorie.save(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @ApiOperation(value = "Delete an account")
    @DeleteMapping("/accounts/{id}")
    public Map<String, Boolean> deleteAccount(
            @ApiParam(value = "Account Id from which account object will delete from database table", required = true) @PathVariable(value = "id") Long accountId)
            throws ResourceNotFoundException {
        Account account = accountRepositorie.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
        accountRepositorie.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}