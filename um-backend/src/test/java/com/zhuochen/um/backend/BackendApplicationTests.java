package com.zhuochen.um.backend;

import com.google.common.collect.Lists;
import com.zhuochen.um.backend.jpa.entity.AccessDataEntity;
import com.zhuochen.um.backend.jpa.entity.RoleDataEntity;
import com.zhuochen.um.backend.jpa.repository.AccessDataRepository;
import com.zhuochen.um.backend.jpa.repository.RoleDataRepository;
import com.zhuochen.um.backend.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@Log4j2
public class BackendApplicationTests {

    @Autowired
    private RoleDataRepository roleDataRepository;

    @Autowired
    private AccessDataRepository accessDataRepository;


    @Test
    @Transactional
    @Rollback(value = false)
    public void initRole() {
        RoleDataEntity roleDataEntity1 = new RoleDataEntity();
        roleDataEntity1.setName("角色1");
        roleDataEntity1.setComment("角色1描述");

        RoleDataEntity roleDataEntity2 = new RoleDataEntity();
        roleDataEntity2.setName("角色2");
        roleDataEntity2.setComment("角色2描述");

        roleDataRepository.saveAll(Lists.newArrayList(roleDataEntity1, roleDataEntity2));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void initAccess() {
        AccessDataEntity accessDataEntity1 = new AccessDataEntity();
        accessDataEntity1.setName("登录");
        accessDataEntity1.setComment("登录");
        accessDataEntity1.setUrl("/login");

        AccessDataEntity accessDataEntity2 = new AccessDataEntity();
        accessDataEntity2.setName("登出");
        accessDataEntity2.setComment("登出");
        accessDataEntity2.setUrl("/logout");

        accessDataRepository.saveAll(Lists.newArrayList(accessDataEntity1, accessDataEntity2));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void manyToManyTest1() {
        roleDataRepository.findById(1L)
                .ifPresent(role -> {
                    accessDataRepository.findById(1L)
                            .ifPresent(access -> {
                                role.getAccessDataEntityList().add(access);
                                roleDataRepository.save(role);
                            });
                });
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void manyToManyTest2() {
        roleDataRepository.findById(1L)
                .ifPresent(role -> {
                    accessDataRepository.findById(2L)
                            .ifPresent(access -> {
                                role.getAccessDataEntityList().add(access);
                                roleDataRepository.save(role);
                            });
                });
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void manyToManyTest3() {
        roleDataRepository.findById(1L)
                .ifPresent(roleDataEntity -> {
                    roleDataEntity.getAccessDataEntityList().parallelStream().forEach(access -> log.info(access.getName()));
                });
    }

    @Autowired
    private RedisService redisService;

    @Test
    public void testKeyValueTemplate() {
        redisService.getRedisUserByToken("");
    }
}
