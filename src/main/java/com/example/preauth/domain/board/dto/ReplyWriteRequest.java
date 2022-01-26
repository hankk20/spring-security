package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.account.AccountDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @ToString
public class ReplyWriteRequest implements Serializable {
    private String contents;
}
