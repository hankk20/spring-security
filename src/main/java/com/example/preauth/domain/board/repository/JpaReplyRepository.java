package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.dto.ReplyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

public interface JpaReplyRepository {
    Page<ReplyDto> findAll(long id, QPageRequest pageRequest);
}
