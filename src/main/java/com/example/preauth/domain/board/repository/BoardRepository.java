package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
