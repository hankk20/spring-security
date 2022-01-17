package com.example.preauth.domain.board.service;

import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.domain.board.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BoardService.class)
class BoardServiceTest {

    @MockBean
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    @Test
    @DisplayName("게시판 작성")
    void test_write(){
        BoardWriteRequest request = new BoardWriteRequest();
        request.setContents("게시판 본문");
        request.setTitle("게시판 제목");


    }

}