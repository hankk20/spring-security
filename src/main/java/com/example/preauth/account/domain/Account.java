package com.example.preauth.account.domain;

import com.example.preauth.account.code.AccountType;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter @NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity @Table(name="account")
public class Account {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @Column(name = "nickname")
    private String nickname;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Setter
    @NaturalId
    @Column(name="account_id", unique = true)
    private String accountId;

    @Setter
    @Column(name="quit")
    private boolean quit = false;

    @Builder
    public Account(String nickname, AccountType accountType, String accountId, boolean quit) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
        this.quit = quit;
    }
}
