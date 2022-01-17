package com.example.preauth.account.repository;

import com.example.preauth.domain.account.code.AccountType;
import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

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
                .nickname("테스트유저")
                .build();

        accountRepository.save(testUser);

    }

}