package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.QReply;
import com.example.preauth.domain.board.Reply;
import com.example.preauth.domain.board.dto.ReplyDto;
import com.querydsl.core.types.OrderSpecifier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class ReplyRepositoryTest {

    @Autowired ReplyRepository repository;

    @Test
    void test(){
        QReply reply = QReply.reply;
        QPageRequest of = QPageRequest.of(2, 5, QSort.by(reply.createDate.asc(), reply.id.asc()));

        Page<ReplyDto> replies = repository.findAll(1L, of);
        log.info("TotlaPage ::{}, TotalElement:: {}, Size ::{}", replies.getTotalPages(), replies.getTotalElements(), replies.getSize());
        log.info("Number ::{}, NumberElement:: {}, Size ::{}", replies.getNumber(), replies.getNumberOfElements());
        log.info("Offset ::{}, PageSize:: {}", of.getOffset(), of.getPageSize());
        Pageable next = of.next();
        log.info("Next Offset ::{}, NumberElement:: {}, Size ::{}", next.getOffset(), next.getPageSize());
        replies.stream().forEach(r -> log.info("R :: {}", r));
    }

}