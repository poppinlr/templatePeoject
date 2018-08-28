package com.zhuochen.um.backend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zhuochen.um.adapter.AdapterApplication;
import com.zhuochen.um.backend.jpa.repository.JpaRepositoryTarget;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = JpaRepositoryTarget.class)
@Import(value = AdapterApplication.class)
@EnableEurekaClient
public class BackendApplication {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory JPAQueryFactory() {
        return new JPAQueryFactory(this.entityManager);
    }


    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
