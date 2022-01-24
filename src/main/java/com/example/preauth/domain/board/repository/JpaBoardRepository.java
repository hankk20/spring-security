package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.dto.BoardDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JpaBoardRepository {

    BoardDto findBoard(Long id, Long accountId);

    Page<BoardDto> findAllBoard(Long accountId, Predicate predicate, Pageable pageRequest);
}
