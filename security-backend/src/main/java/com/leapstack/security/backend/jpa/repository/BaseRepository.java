package com.leapstack.security.backend.jpa.repository;

import com.leapstack.security.backend.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    List<T> findByActive(boolean active);
}
