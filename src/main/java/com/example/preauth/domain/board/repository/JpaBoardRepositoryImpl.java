package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.QAccount;
import com.example.preauth.domain.account.QAccountDto;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.QBoard;
import com.example.preauth.domain.board.QBoardLike;
import com.example.preauth.domain.board.QReply;
import com.example.preauth.domain.board.dto.BoardDto;
import com.example.preauth.domain.board.dto.QBoardDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

import static com.querydsl.core.types.ExpressionUtils.count;

public class JpaBoardRepositoryImpl extends QuerydslRepositorySupport implements JpaBoardRepository {

    QBoard board = QBoard.board;

    public JpaBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public BoardDto findBoard(long id, long accountId){
        return getBoardDtoQuery(accountId)
                .where(board.id.eq(id))
                .fetchOne();
    }

    @Override
    public Page<BoardDto> findAllBoard(Predicate predicate, Pageable pageRequest){
        JPQLQuery<Board> countQuery = createCountQuery(predicate);

        JPQLQuery<BoardDto> query = getBoardDtoQuery(null)
                .where(predicate);

        JPQLQuery<BoardDto> boardDtoJPQLQuery = getQuerydsl().applyPagination(pageRequest, query);
        return PageableExecutionUtils.getPage(boardDtoJPQLQuery.fetch(), pageRequest, countQuery::fetchCount);
    }

    @Override
    public Page<BoardDto> findAllBoard(long accountId, Predicate predicate, Pageable pageRequest){
        JPQLQuery<Board> countQuery = createCountQuery(predicate);

        JPQLQuery<BoardDto> query = getBoardDtoQuery(accountId)
                .where(predicate);

        JPQLQuery<BoardDto> boardDtoJPQLQuery = getQuerydsl().applyPagination(pageRequest, query);
        return PageableExecutionUtils.getPage(boardDtoJPQLQuery.fetch(), pageRequest, countQuery::fetchCount);
    }

    private JPQLQuery<Board> createCountQuery(Predicate predicate){
        QAccount account = QAccount.account;
        return from(board)
                .join(board.account, account)
                .where(predicate);
    }

    private JPQLQuery<BoardDto> getBoardDtoQuery(Long id){
        QBoard board = QBoard.board;
        QBoardLike like = QBoardLike.boardLike;
        QBoardLike myLike = new QBoardLike("myLike");
        QReply reply = QReply.reply;
        QAccount account = QAccount.account;
        return from(board)
                .join(board.account, account)
                .leftJoin(board.boardLikes, like)
                .leftJoin(board.boardLikes, myLike)
                .on(myLike.account.id.eq(id))
                .select(new QBoardDto(board.id,
                        new QAccountDto(account.id,
                                account.accountId,
                                account.nickname,
                                account.accountType,
                                account.quit),
                        board.title,
                        board.contents,
                        board.createDate,
                        board.updateDate,
                        like.id.count(),
                        JPAExpressions.select(count(reply.id))
                                .from(reply)
                                .where(reply.board.id.eq(board.id)),
                        myLike.id.isNotNull()
                ))
                .groupBy(board.id);
    }

}
