package com.zhuochen.um.backend.jpa.repository;

import com.zhuochen.um.backend.jpa.entity.AccessDataEntity;
import com.zhuochen.um.backend.jpa.repository.base.BaseDataRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessDataRepository extends BaseDataRepository<AccessDataEntity>, QuerydslPredicateExecutor<AccessDataEntity> {

}
