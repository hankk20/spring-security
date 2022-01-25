package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class BoardWriteRequest {
    @NotBlank
    String contents;
    @NotBlank
    String title;
}
