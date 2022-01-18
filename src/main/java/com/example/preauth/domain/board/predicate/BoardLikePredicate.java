package com.example.preauth.domain.board.predicate;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.QBoardLike;
import com.querydsl.core.types.dsl.BooleanExpression;

public class BoardLikePredicate {
    public static BooleanExpression compositeKey(long boardId, Account account){
        QBoardLike boardLike = QBoardLike.boardLike;
        return boardLike.account.eq(account).and(boardLike.board.id.eq(boardId));
    }
}
