package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReplyRepository extends JpaRepository<Reply, Long>, QuerydslPredicateExecutor<Reply>, JpaReplyRepository {

}
