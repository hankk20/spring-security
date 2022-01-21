package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.board.BoardDisplayDate;
import com.example.preauth.domain.board.DisplayAccount;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @ToString
public class ReplyDto implements Serializable {
    private long id;
    private long accountId;
    private DisplayAccount displayAccount;
    private String contents;
    private BoardDisplayDate createDate;
    private BoardDisplayDate updateDate;

    @QueryProjection
    public ReplyDto(long id, long accountId, DisplayAccount displayAccount, String contents, BoardDisplayDate createDate, BoardDisplayDate updateDate) {
        this.id = id;
        this.accountId = accountId;
        this.displayAccount = displayAccount;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
