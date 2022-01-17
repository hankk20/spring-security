package com.example.preauth.domain.account;

import com.example.preauth.domain.account.code.AccountType;
import com.example.preauth.domain.commons.AuditProperties;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * 수정가능한 항목에만 setter 메소드를 만든다.
 * 생성자에는 필수값들로 채운다.
 */
@Getter @NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity @Table(name="account")
public class Account extends AuditProperties {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id", nullable = false)
    private Long id;

    @NaturalId
    @Column(name="account_id", unique = true)
    private String accountId;

    @Setter
    @Column(name = "nickname")
    private String nickname;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Setter
    @Column(name="quit")
    private boolean quit = false;

    @Builder
    public Account(String nickname, AccountType accountType, String accountId) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
    }
}
