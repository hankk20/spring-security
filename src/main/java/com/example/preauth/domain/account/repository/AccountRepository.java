package com.example.preauth.domain.account.repository;

import com.example.preauth.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account>{

    public Optional<Account> findByAccountId(String accountId);
}
