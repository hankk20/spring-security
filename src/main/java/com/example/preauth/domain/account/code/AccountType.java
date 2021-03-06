package com.example.preauth.domain.account.code;

import com.example.preauth.domain.commons.code.DisplayName;
import com.fasterxml.jackson.annotation.JsonFormat;

public enum AccountType implements DisplayName {

    LESSOR("임대인"),
    REALTOR("공인 중개사"),
    LESSEE("임차인");

    private String displayName;

    AccountType(String name){
        this.displayName = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

}
