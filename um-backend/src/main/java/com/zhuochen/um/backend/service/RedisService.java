package com.zhuochen.um.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhuochen.um.backend.config.constants.CommonSymbol;
import com.zhuochen.um.backend.domain.RedisUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CommonService commonService;

    /**
     * generateTokenKeyByUsername
     * @param username username
     * @return key
     *
     * redis key: generate key, value: token
     */
    private String generateTokenKeyByUsername(String username) {
        return "USERNAME_USER_TOKEN_KEY" + CommonSymbol.USER_TOKEN_GENERATE_SYMBOL + username;
    }

    public Optional<String> getTokenByUsername(String username) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get(this.generateTokenKeyByUsername(username)));
    }

    public void extendTokenByUsername(String username, String token, Long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(this.generateTokenKeyByUsername(username), token, time, timeUnit);
    }

    public Optional<RedisUserData> getRedisUserByToken(String token) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get(token))
                .map(user -> commonService.convertJsonToObject(user, RedisUserData.class));
    }

    public void deleteRedisUserByToken(String token) {
        stringRedisTemplate.delete(token);
    }

    public void extendRedisUserDataByToken(String token, RedisUserData redisUserData) {
        stringRedisTemplate.opsForValue().set(token, commonService.convertObjectToJson(redisUserData), 30, TimeUnit.MINUTES);
    }
}
