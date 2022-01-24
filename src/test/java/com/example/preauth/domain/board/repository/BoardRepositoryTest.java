package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.repository.AccountRepository;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.QBoard;
import com.example.preauth.domain.board.Reply;
import com.example.preauth.domain.board.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.annotation.Commit;

import java.util.List;
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
        List<Account> all = accountRepository.findAll();
        all.stream()
                .forEach(board::addLike);

        int i = 5;
        for (int i1 = 0; i1 < i; i1++) {
            board.addReply(new Reply(writer, "댓글"+i1));
        }
        boardRepository.save(board);
        BoardDto board1 = boardRepository.findBoard(board.getId(), writer.getId());
        log.info("Result :: {}", board1);

        Page<BoardDto> all1 = boardRepository.findAllBoard(new Long(1),null, PageRequest.of(0, 3, Sort.by("createDate").ascending().and(Sort.by("id").ascending())));
        all1.stream()
                .forEach(System.out::println);

    }
}