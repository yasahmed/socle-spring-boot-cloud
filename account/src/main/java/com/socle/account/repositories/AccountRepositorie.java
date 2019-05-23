package com.socle.account.repositories;

import com.socle.account.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositorie extends JpaRepository<Account, Long> {
}
