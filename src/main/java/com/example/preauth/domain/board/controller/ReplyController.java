package com.example.preauth.domain.board.controller;


import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.Reply;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.BoardModifyRequest;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.domain.board.dto.ReplyWriteRequest;
import com.example.preauth.domain.board.repository.BoardRepository;
import com.example.preauth.domain.board.service.BoardService;
import com.example.preauth.domain.board.service.ReplyService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;


    @PostMapping("/board/{id}/reply")
    public ResponseEntity<Long> write(@AuthenticationPrincipal(expression = "account") Account account,
                                      @PathVariable("id")Long id,
                                      @RequestBody ReplyWriteRequest request){
        return ResponseEntity.ok(replyService.write(id, account, request));
    }
    @PutMapping("/board/reply/{id}")
    public ResponseEntity<Long> update(@AuthenticationPrincipal(expression = "account") Account account,
                                      @PathVariable("id")Long id,
                                      @RequestBody ReplyWriteRequest request){
        return ResponseEntity.ok(replyService.update(id, request));
    }
    @DeleteMapping("/board/reply/{id}")
    public ResponseEntity<Long> delete(@AuthenticationPrincipal(expression = "account") Account account,
                                       @PathVariable("id")Long id){

        return ResponseEntity.ok(replyService.delete(id));
    }




}
