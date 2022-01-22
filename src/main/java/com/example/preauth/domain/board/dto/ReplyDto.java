package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.account.AccountDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @ToString
public class ReplyDto implements Serializable {
    private long id;
    private AccountDto accountDto;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @QueryProjection
    public ReplyDto(long id, AccountDto accountDto, String contents, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.accountDto = accountDto;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
