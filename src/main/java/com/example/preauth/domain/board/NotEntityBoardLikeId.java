package com.example.preauth.domain.board;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotEntityBoardLikeId implements Serializable {
    private long boardId;
    private long accountId;
}
