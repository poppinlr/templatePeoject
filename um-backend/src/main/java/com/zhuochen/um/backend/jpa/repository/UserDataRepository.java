package com.zhuochen.um.backend.jpa.repository;

import com.zhuochen.um.backend.jpa.entity.UserDataEntity;
import com.zhuochen.um.backend.jpa.repository.base.BaseDataRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends BaseDataRepository<UserDataEntity>, QuerydslPredicateExecutor<UserDataEntity> {

    Optional<UserDataEntity> findByUsernameAndActive(String username, Boolean active);
}
