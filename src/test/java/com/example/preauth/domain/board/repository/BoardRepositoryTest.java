package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.repository.AccountRepository;
import com.example.preauth.domain.board.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Commit
    void test_simple(){
        Account writer = accountRepository.findByAccountId("Lessor 21").get();
        Board board = new Board(writer, "test contests");
        boardRepository.save(board);
    }
}