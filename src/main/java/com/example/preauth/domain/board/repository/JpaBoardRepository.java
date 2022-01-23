package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

public interface JpaBoardRepository {


    BoardDto findBoard(long id);

    Page<BoardDto> findAllBoard(Predicate predicate, Pageable pageRequest);

    Page<BoardDto> findAllBoard(long accountId, Predicate predicate, Pageable pageRequest);
}
