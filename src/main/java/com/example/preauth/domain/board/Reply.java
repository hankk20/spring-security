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
@Entity @Table(name="reply")
public class Reply extends AuditProperties {

    @EqualsAndHashCode.Include
    @SequenceGenerator(name="reply_seq", sequenceName = "reply_seq", allocationSize = 1)
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "reply_seq") @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @Column(name = "contents", nullable = false, length = 4000)
    private String contents;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    protected Reply(){}

    public Reply(Account account, String contents){
        this.account = account;
        this.contents = contents;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
