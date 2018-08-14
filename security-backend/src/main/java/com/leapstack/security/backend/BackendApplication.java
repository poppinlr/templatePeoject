package com.leapstack.security.backend;

import com.leapstack.security.adapter.AdapterApplication;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EnableTransactionManagement
@Import(value = AdapterApplication.class)
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
