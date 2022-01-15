package com.example.preauth.domain.commons;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditProperties {

    @CreatedBy
    private String createId;

    @LastModifiedBy
    private String modifyId;

    @CreatedDate
    private LocalDate createDate;

    @LastModifiedDate
    private LocalDate updateDate;
}
