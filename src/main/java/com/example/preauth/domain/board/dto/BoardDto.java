package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.account.AccountDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
public class BoardDto implements Serializable {
    private long id;
    private AccountDto accountDto;
    private String title;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private long likeCount;
    private long replyCount;
    private boolean liked;

    @QueryProjection
    public BoardDto(long id, AccountDto accountDto, String title, String contents, LocalDateTime createDate, LocalDateTime updateDate, long likeCount, long replyCount, boolean liked) {
        this.id = id;
        this.accountDto = accountDto;
        this.title = title;
        this.contents = contents;
        this.likeCount = likeCount;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.replyCount = replyCount;
        this.liked = liked;
    }
}
