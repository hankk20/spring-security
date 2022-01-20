package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardDto;

public interface JpaBoardRepository {


    BoardDto findBoard(long id);

    Board findBoard2(long id);
}
