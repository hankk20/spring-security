package com.example.preauth.domain.board.controller;


import com.example.preauth.domain.board.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BoardController {

    @GetMapping("/test")
    @PreAuthorize("!hasRole('ANONYMOUS')")
    public ResponseEntity test(){
        log.info("test In!!");
        return ResponseEntity.ok().build();
    }
}
