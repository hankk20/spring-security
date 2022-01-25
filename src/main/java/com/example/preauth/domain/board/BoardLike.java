package com.example.preauth.domain.board;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Getter @EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity @Table(name = "board_like")
@Audited
public class BoardLike extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @Setter
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    protected BoardLike(){}

    public BoardLike(Board board, Account account) {
        this.board = board;
        this.account = account;
    }

}
