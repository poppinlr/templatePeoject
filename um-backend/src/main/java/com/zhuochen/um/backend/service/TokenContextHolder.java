package com.zhuochen.um.backend.service;

import com.zhuochen.um.adapter.config.constants.RequestHeaderConstant;
import com.zhuochen.um.backend.domain.RedisUserData;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

public class TokenContextHolder {

    public static Optional<RedisUserData> getRedisUser() {
        return Optional.ofNullable(RequestContextHolder.currentRequestAttributes().getAttribute(RequestHeaderConstant.CONTEXT_HOLDER_REDIS_USER, RequestAttributes.SCOPE_REQUEST))
                .map(object -> (RedisUserData) object);
    }

    public static void setRedisUser(RedisUserData redisUser) {
        RequestContextHolder.currentRequestAttributes().setAttribute(RequestHeaderConstant.CONTEXT_HOLDER_REDIS_USER, redisUser, RequestAttributes.SCOPE_REQUEST);
    }
}
