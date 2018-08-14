package com.leapstack.security.backend.jpa.entity;

import com.leapstack.security.backend.config.listener.CreateAndModifyListener;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(value = CreateAndModifyListener.class)
public class BaseEntity {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "active")
    private Boolean active = true;//default true
}
