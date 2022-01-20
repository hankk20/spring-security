package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.QAccount;
import com.example.preauth.domain.board.*;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.QBoardDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

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
                .join(board.writer, account)
                .leftJoin(board.replies, reply)
                .leftJoin(board.boardLikes, like)
                .select(new QBoardDto(board.id,
                        new QDisplayAccount(board.writer.accountType, board.writer.nickname),
                        board.title,
                        board.contents,
                        board.createDate,
                        board.updateDate
                        ))
                .where(board.id.eq(id))
                .fetchOne();
    }
    @Override
    public Board findBoard2(long id){
        QBoard board = QBoard.board;
        QBoardLike like = QBoardLike.boardLike;
        QReply reply = QReply.reply;
        QAccount account = QAccount.account;
        return from(board)
                .join(board.writer, account)
                .fetchJoin()
                .leftJoin(board.replies, reply)
                .leftJoin(board.boardLikes, like)
                .where(board.id.eq(id))
                .fetchOne();
    }

}
