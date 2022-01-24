package com.example.preauth.domain.board.predicate;

import com.example.preauth.domain.board.QBoard;
import com.querydsl.core.types.Predicate;

public class BoardPredicate {

    public static Predicate eqAccountId(Long accountId){
        if(accountId != null && accountId.longValue() != 0) {
            return QBoard.board.account.id.eq(accountId);
        }
        return null;
    }
}
