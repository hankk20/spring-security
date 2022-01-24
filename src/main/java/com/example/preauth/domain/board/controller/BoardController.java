package com.example.preauth.domain.board.controller;


import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.BoardModifyRequest;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.domain.board.repository.BoardRepository;
import com.example.preauth.domain.board.service.BoardService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping
    public ResponseEntity<List<BoardDto>> boardList(@AuthenticationPrincipal(expression = "account") Account account,
                                                    @QuerydslPredicate(root = Board.class) Predicate predicate, Pageable pageable){
        Page<BoardDto> allBoard = boardRepository.findAllBoard(account.getId(), predicate, pageable);
        return ResponseEntity.ok(allBoard.getContent());
    }

    @PostMapping
    public ResponseEntity<Long> write(@AuthenticationPrincipal(expression = "account") Account account,
                                      @RequestBody BoardWriteRequest request){
        return ResponseEntity.ok(boardService.write(account, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> board(@AuthenticationPrincipal(expression = "account")Account account,
                                          @PathVariable("id") long id){
        return ResponseEntity.ok(boardRepository.findBoard(id, account.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@AuthenticationPrincipal(expression = "account") Account account,
                                       @PathVariable("id") long id, @RequestBody BoardModifyRequest request){
        return ResponseEntity.ok(boardService.update(id, account, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@AuthenticationPrincipal(expression = "account") Account account,
                                       @PathVariable("id") long id){
        return ResponseEntity.ok(boardService.delete(account, id));
    }

}
