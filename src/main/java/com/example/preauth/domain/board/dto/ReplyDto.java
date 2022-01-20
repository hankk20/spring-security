package com.example.preauth.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto implements Serializable {
    private Long id;
    private String accountName;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String contents;
}
