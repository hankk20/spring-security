package com.example.preauth.domain.board.service;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardModifyRequest;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public long write(Account wrtier, BoardWriteRequest request){
        Board board = new Board(wrtier, request.getTitle(), request.getContents());
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }

    /**
     * 작성자가 동일할경우에만 수정 가능
     * @param writer
     * @param request
     * @return
     */
    public long update(Account writer, BoardModifyRequest request){
        Board board = findOrElseThrow(request.getId());
        //수정권한 검사
        board.checkUpdatePermission(writer);
        return update(board, request);
    }

    /**
     * 관리자만 강제 수정 가능
     * @param request
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    public long forceUpdate(BoardModifyRequest request){
        Board board = findOrElseThrow(request.getId());
        return update(board, request);
    }

    private long update(Board board, BoardModifyRequest request){
        board = request.update(board);
        boardRepository.save(board);
        return board.getId();
    }

    /**
     * 조회 데이터가없으면 오류 발생
     * @param id
     * @return
     */
    public Board findOrElseThrow(long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 정보를 찿을 수 없습니다.")); //Exception 정의 필요
    }
}
