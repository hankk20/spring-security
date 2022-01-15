package com.example.preauth.domain.board;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity @Table(name="board")
public class Board extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contents", nullable = false, length = 4000)
    private String contents;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account writer;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();

    protected Board(){}

    public Board(Account writer, String contents){
        this.writer = writer;
        this.contents = contents;
    }

    public void addReply(Reply reply){
        reply.setBoard(this);
        replies.add(reply);
    }
}
