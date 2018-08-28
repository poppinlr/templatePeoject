package com.zhuochen.um.backend.config.listener;

import com.zhuochen.um.backend.jpa.entity.base.BaseDataEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class CreateAndModifyListener {

    @PrePersist
    public void setCreatedAtAndCreatedBy(BaseDataEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        setModifiedAtAndModifiedBy(entity);
    }

    @PreUpdate
    public void setModifiedAtAndModifiedBy(BaseDataEntity entity) {
        entity.setModifiedAt(LocalDateTime.now());
    }
}
