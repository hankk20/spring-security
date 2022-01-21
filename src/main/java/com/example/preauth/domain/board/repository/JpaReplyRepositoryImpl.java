package com.example.preauth.domain.board.repository;

import com.example.preauth.domain.account.QAccount;
import com.example.preauth.domain.board.QBoardDisplayDate;
import com.example.preauth.domain.board.QDisplayAccount;
import com.example.preauth.domain.board.QReply;
import com.example.preauth.domain.board.Reply;
import com.example.preauth.domain.board.dto.QReplyDto;
import com.example.preauth.domain.board.dto.ReplyDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.support.PageableExecutionUtils;

public class JpaReplyRepositoryImpl extends QuerydslRepositorySupport implements JpaReplyRepository{

    private QReply reply = QReply.reply;

    public JpaReplyRepositoryImpl() {
        super(Reply.class);
    }

    @Override
    public Page<ReplyDto> findAll(long id, QPageRequest pageRequest){
        BooleanExpression predicate = reply.board.id.eq(id);

        QAccount account = QAccount.account;

        JPQLQuery<Reply> defaultQuery = from(reply)
                .join(reply.account, account)
                .where(predicate);

        JPQLQuery<ReplyDto> query = defaultQuery
                .select(new QReplyDto(
                        reply.id,
                        account.id,
                        new QDisplayAccount(account.accountType, account.nickname),
                        reply.contents,
                        new QBoardDisplayDate(reply.createDate),
                        new QBoardDisplayDate(reply.updateDate)
                ));

        JPQLQuery<ReplyDto> pageQuery = getQuerydsl().applyPagination(pageRequest, query);

        return PageableExecutionUtils.getPage(pageQuery.fetch(), pageRequest, defaultQuery::fetchCount);

    }

    protected JPQLQuery<Reply> createCountQuery(Predicate predicate){
        JPQLQuery<Reply> query = from(reply);
        if(predicate != null){
            query = query.where(predicate);
        }
        return query;
    }
}
