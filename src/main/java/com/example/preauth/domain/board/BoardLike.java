package com.example.preauth.domain.board;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Getter @EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity @Table(name = "board_like")
public class BoardLike extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    protected BoardLike(){}

    public BoardLike(Board board, Account account) {
        this.board = board;
        this.account = account;
    }

}
