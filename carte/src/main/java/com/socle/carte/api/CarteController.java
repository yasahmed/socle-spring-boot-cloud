package com.socle.carte.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.socle.carte.domains.Carte;
import com.socle.carte.repositories.CarteRepository;
import com.socle.commons.exceptions.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Cards Management System", description = "Operations pertaining to employee in Card Management System")
public class CarteController {
    @Autowired
    private CarteRepository carteRepository;

    @ApiOperation(value = "View a list of available cartes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/cartes")
    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    @ApiOperation(value = "Get an carte by Id")
    @GetMapping("/cartes/{id}")
    public ResponseEntity<Carte> getCarteById(
            @ApiParam(value = "Carte id from which carte object will retrieve", required = true) @PathVariable(value = "id") Long carteId)
            throws ResourceNotFoundException {
        Carte carte = carteRepository.findById(carteId)
                .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));
        return ResponseEntity.ok().body(carte);
    }

    @ApiOperation(value = "Add an carte")
    @PostMapping("/cartes")
    public Carte createCarte(
            @ApiParam(value = "Carte object store in database table", required = true) @Valid @RequestBody Carte carte) {
        return carteRepository.save(carte);
    }

    @ApiOperation(value = "Update an carte")
    @PutMapping("/cartes/{id}")
    public ResponseEntity<Carte> updateEmployee(
            @ApiParam(value = "Employee Id to update carte object", required = true) @PathVariable(value = "id") Long carteId,
            @ApiParam(value = "Update carte object", required = true) @Valid @RequestBody Carte carteDetails) throws ResourceNotFoundException {
        Carte carte = carteRepository.findById(carteId)
                .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));
        carte.setId(carteDetails.getId());
        carte.setNumCard(carteDetails.getNumCard());
        carte.setPlafond(carteDetails.getPlafond());
        final Carte updatedCarte = carteRepository.save(carte);
        return ResponseEntity.ok(updatedCarte);
    }

    @ApiOperation(value = "Delete an carte")
    @DeleteMapping("/cartes/{id}")
    public Map<String, Boolean> deleteCarte(
            @ApiParam(value = "Carte Id from which employee object will delete from database table", required = true) @PathVariable(value = "id") Long carteId)
            throws ResourceNotFoundException {
        Carte carte = carteRepository.findById(carteId)
                .orElseThrow(() -> new ResourceNotFoundException("Carte not found for this id :: " + carteId));
        carteRepository.delete(carte);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}