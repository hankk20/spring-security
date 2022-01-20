package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.board.BoardDisplayDate;
import com.example.preauth.domain.board.DisplayAccount;
import com.example.preauth.domain.commons.ApplicationConstants;
import com.example.preauth.domain.commons.DisplayDate;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class BoardDto implements Serializable {
    private long id;
    private DisplayAccount accountName;
    private String title;
    private String contents;
    private DisplayDate createDate;
    private DisplayDate updateDate;
    private long likeCount;
    //private List<ReplyDto> replies = new ArrayList<>();

    @QueryProjection
    public BoardDto(long id, DisplayAccount accountName, String title, String contents, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.accountName = accountName;
        this.title = title;
        this.contents = contents;
        this.likeCount = likeCount;
        this.createDate = new BoardDisplayDate(createDate);
        this.updateDate =new BoardDisplayDate(updateDate);
      //  this.replies = replies;
    }
}
