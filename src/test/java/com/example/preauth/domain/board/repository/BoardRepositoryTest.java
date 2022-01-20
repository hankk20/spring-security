package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.repository.AccountRepository;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Commit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@EnableJpaAuditing
@DataJpaTest
@Slf4j
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Commit
    void test_simple(){
        Account writer = accountRepository.findByAccountId("Lessor 21").get();
        Board board = new Board(writer, "test title", "test contents");
        boardRepository.save(board);
        Board board2 = boardRepository.findBoard2(board.getId());
        log.info("Result :: {}", board2.getWriter().getAccountType());
        BoardDto board1 = boardRepository.findBoard(board.getId());
        log.info("Result :: {}", board1);
    }
}