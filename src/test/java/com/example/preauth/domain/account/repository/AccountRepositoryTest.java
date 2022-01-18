package com.example.preauth.domain.account.repository;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.QAccount;
import com.example.preauth.domain.account.code.AccountType;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@Slf4j
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("QueryDsl Predicate 공부")
    void test_queryDslPredicate(){
        QAccount account = QAccount.account;
        BooleanExpression eq = account.accountType.eq(AccountType.REALTOR);
        Iterable<Account> all = accountRepository.findAll(eq);
        for (Account account1 : all) {
            log.info(account1.toString());
        }

        BooleanExpression and = account.accountType.eq(AccountType.REALTOR).and(account.quit.eq(true));
        Optional<Account> one = accountRepository.findOne(and);
        log.info("findOne :: {}", one.get().toString());
    }
}