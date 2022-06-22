package com.example.preauth.domain.board;


import com.example.preauth.domain.commons.AuditProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "NO_ENTITY_LIKE")
@Embeddable
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED) @Getter
public class NotEntityBoardLike extends AuditProperties {
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name="boardId", column = @Column(name = "board_id")),
            @AttributeOverride(name="accountId", column = @Column(name="account_id"))
    })
    private NotEntityBoardLikeId id;

    public static NotEntityBoardLike create(long boardId, long accountId){
        return new NotEntityBoardLike(new NotEntityBoardLikeId(boardId, accountId));
    }
}
