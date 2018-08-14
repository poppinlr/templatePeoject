package com.leapstack.security.backend.config.listener;

import com.leapstack.security.backend.jpa.entity.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class CreateAndModifyListener {

    @PrePersist
    public void setCreatedAtAndCreatedBy(BaseEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        setModifiedAtAndModifiedBy(entity);
    }

    @PreUpdate
    public void setModifiedAtAndModifiedBy(BaseEntity entity) {
        entity.setModifiedAt(LocalDateTime.now());
    }
}
