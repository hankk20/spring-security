package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.board.DisplayAccount;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @ToString
public class ReplyDto implements Serializable {
    private Long id;
    private DisplayAccount displayAccount;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @QueryProjection
    public ReplyDto(Long id, DisplayAccount displayAccount, String contents, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.displayAccount = displayAccount;
        this.contents = contents;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
