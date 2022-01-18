package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long>, QuerydslPredicateExecutor {

}
