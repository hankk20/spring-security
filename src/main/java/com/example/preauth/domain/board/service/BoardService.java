package com.example.preauth.domain.board.service;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.BoardModifyRequest;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.domain.board.repository.BoardRepository;
import com.example.preauth.web.exception.CustomSystemException;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
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
    public long update(long id, Account writer, BoardModifyRequest request){
        Board board = findOrElseThrow(id);
        //수정권한 검사
        board.checkPermission(writer);
        return update(board, request);
    }

    /**
     * 관리자만 강제 수정 가능
     * @param request
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    public long forceUpdate(long id, BoardModifyRequest request){
        Board board = findOrElseThrow(id);
        return update(board, request);
    }

    private long update(Board board, BoardModifyRequest request){
        board = request.update(board);
        boardRepository.save(board);
        return board.getId();
    }

    public long delete(Account account, long id){
        Board board = findOrElseThrow(id);
        board.checkPermission(account);
        board.delete();
        return id;
    }

    /**
     * 조회 데이터가없으면 오류 발생
     * @param id
     * @return
     */
    public Board findOrElseThrow(long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new CustomSystemException("게시글 정보를 찿을 수 없습니다.", HttpStatus.NOT_FOUND)); //Exception 정의 필요
    }
}
