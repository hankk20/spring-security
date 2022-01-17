package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardModifyRequest {
    private long id;
    private BoardWriteRequest boardWriteRequest;

    //수정가능 항목을 셋팅하는 부분을 캡슐화
    public Board update(Board board){
        board.setTitle(boardWriteRequest.getTitle());
        board.setContents(boardWriteRequest.getContents());
        return board;
    }
}
