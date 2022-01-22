package com.example.preauth.domain.account;

import com.example.preauth.domain.account.code.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AccountDto implements Serializable {
    private Long id;
    private String accountId;
    private String nickname;
    private AccountType accountType;
    private boolean quit = false;

    @QueryProjection
    public AccountDto(Long id, String accountId, String nickname, AccountType accountType, boolean quit) {
        this.id = id;
        this.accountId = accountId;
        this.nickname = nickname;
        this.accountType = accountType;
        this.quit = quit;
    }

    @JsonProperty
    private String accountTypeName(){
        return accountType.getDisplayName();
    }
}
