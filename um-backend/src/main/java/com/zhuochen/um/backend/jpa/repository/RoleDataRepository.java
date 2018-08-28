package com.zhuochen.um.backend.jpa.repository;

import com.zhuochen.um.backend.jpa.entity.RoleDataEntity;
import com.zhuochen.um.backend.jpa.repository.base.BaseDataRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDataRepository extends BaseDataRepository<RoleDataEntity>, QuerydslPredicateExecutor<RoleDataEntity> {

}
