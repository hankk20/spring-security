package com.example.preauth.account.repository;

import com.example.preauth.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findByAccountId(String accountId);
}
