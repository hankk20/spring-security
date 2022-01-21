package com.example.preauth.domain.board;

import com.example.preauth.domain.account.code.AccountType;
import com.querydsl.core.annotations.QueryProjection;

public class DisplayAccount {

    private AccountType type;
    private String nickname;
    private final String format = "%s (%s)";

    @QueryProjection
    public DisplayAccount(AccountType type, String nickname) {
        this.type = type;
        this.nickname = nickname;
    }

    public String display(){
        return String.format(format, nickname, type.getDisplayName());
    }
}
