package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaBoardRepository {

    @Override
    @EntityGraph(value = "account-entity-g", attributePaths = "account")
    List<Board> findAll();
}
