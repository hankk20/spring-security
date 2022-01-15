package com.example.preauth.domain.board;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Getter @EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity @Table(name="reply")
public class Reply extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contents", nullable = false, length = 4000)
    private String contents;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    protected Reply(){}

    public Reply(Account writer, String contents){
        this.writer = writer;
        this.contents = contents;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
