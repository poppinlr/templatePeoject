package com.zhuochen.um.backend.config.interceptor;

import com.zhuochen.um.adapter.config.enums.ResponseCommonCodeEnum;
import com.zhuochen.um.adapter.web.ResponseMessageWrapper;
import com.zhuochen.um.backend.domain.RedisUserData;
import com.zhuochen.um.backend.service.CommonService;
import com.zhuochen.um.backend.service.RedisService;
import com.zhuochen.um.backend.service.TokenContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CommonService commonService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<RedisUserData> user = TokenContextHolder.getRedisUser();
        if (user.isPresent()) {
            String token = user.get().getToken();
            Optional<RedisUserData> optionalRedisUserData = redisService.getRedisUserByToken(token);
            if (optionalRedisUserData.isPresent()) {
                redisService.extendRedisUserDataByToken(token, optionalRedisUserData.get());
                return true;
            } else {
                response.getWriter().write(commonService.convertObjectToJson(new ResponseMessageWrapper<>(ResponseCommonCodeEnum.AUTH_FAIL, null)));
                return false;
            }
        } else {
            response.getWriter().write(commonService.convertObjectToJson(new ResponseMessageWrapper<>(ResponseCommonCodeEnum.AUTH_FAIL, null)));
            return false;
        }
    }
}
