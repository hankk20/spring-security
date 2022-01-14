package com.example.preauth.account.repository;

import com.example.preauth.account.code.AccountType;
import com.example.preauth.account.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Commit
    void test_insert(){
        Account testUser = Account.builder()
                .accountId("Realtor 47")
                .accountType(AccountType.REALTOR)
                .quit(false)
                .nickname("테스트유저")
                .build();

        accountRepository.save(testUser);

    }

}