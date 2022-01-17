package com.example.preauth.domain.board.dto;

import com.example.preauth.domain.account.Account;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardWriteRequest {
    String contents;
    String title;
}
