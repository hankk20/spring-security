package com.example.preauth.domain.board;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity @Table(name="board")
public class Board extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account writer;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();

    @Setter
    @Column(name = "title", nullable = false, length = 1000)
    private String title;

    @Setter
    @Column(name = "contents", nullable = false, length = 4000)
    private String contents;

    protected Board(){}

    public Board(Account writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }

    public void addReply(Reply reply){
        reply.setBoard(this);
        replies.add(reply);
    }

    public void checkUpdatePermission(Account writer){
        if(!equalsWriter(writer)){
            throw new RuntimeException("수정 권한이 없습니다."); //TODO Exception 정의하자
        }
    }

    public boolean equalsWriter(Account writer){
        return this.writer.equals(writer);
    }
}
