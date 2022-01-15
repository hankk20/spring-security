package com.example.preauth.domain.account;

import com.example.preauth.domain.account.code.AccountType;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter @NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity @Table(name="account")
public class Account extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
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
