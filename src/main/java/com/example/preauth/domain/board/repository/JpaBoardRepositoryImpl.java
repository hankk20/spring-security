package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.QAccount;
import com.example.preauth.domain.board.*;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.QBoardDto;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.querydsl.core.types.ExpressionUtils.count;

public class JpaBoardRepositoryImpl extends QuerydslRepositorySupport implements JpaBoardRepository {


    public JpaBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public BoardDto findBoard(long id){
        QBoard board = QBoard.board;
        QBoardLike like = QBoardLike.boardLike;
        QReply reply = QReply.reply;
        QAccount account = QAccount.account;

        return from(board)
                .join(board.account, account)
                .leftJoin(board.boardLikes, like)
                .select(new QBoardDto(board.id,
                        new QDisplayAccount(board.account.accountType, board.account.nickname),
                        board.title,
                        board.contents,
                        board.createDate,
                        board.updateDate,
                        like.id.count(),
                        JPAExpressions.select(count(reply.id))
                                .from(reply)
                                .where(reply.board.id.eq(id))
                        ))
                .where(board.id.eq(id))
                .groupBy(board.id)
                .fetchOne();
    }

}
