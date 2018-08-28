package com.zhuochen.um.backend.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.zhuochen.um.adapter.config.enums.ResponseCommonCodeEnum;
import com.zhuochen.um.adapter.web.ResponseMessageWrapper;
import com.zhuochen.um.adapter.web.login.LoginRequest;
import com.zhuochen.um.adapter.web.login.LoginResponse;
import com.zhuochen.um.backend.config.constants.CommonSymbol;
import com.zhuochen.um.backend.jpa.entity.UserDataEntity;
import com.zhuochen.um.backend.jpa.repository.UserDataRepository;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private RedisService redisService;

    public ResponseMessageWrapper<LoginResponse> login(LoginRequest loginRequest) {
        return userDataRepository.findByUsernameAndActive(loginRequest.getUsername(), true)
                .map(user -> {
                    if (user.getPassword().equals(loginRequest.getPassword())) {
                        try {
                            String username = user.getName();
                            String token = MessageDigest.getInstance(username + CommonSymbol.USER_TOKEN_GENERATE_SYMBOL + LocalDateTime.now().toString()).toString();
                            //delete token related user
                            redisService.getTokenByUsername(username)
                                    .ifPresent(t -> redisService.deleteRedisUserByToken(t));
                            //reset token
                            redisService.extendTokenByUsername(username, token, 30L, TimeUnit.MINUTES);
                            LoginResponse response = new LoginResponse();
                            BeanUtils.copyProperties(user, response);
                            response.setToken(token);
                            return new ResponseMessageWrapper<>(response);
                        } catch (NoSuchAlgorithmException e) {
                            return new ResponseMessageWrapper<LoginResponse>(ResponseCommonCodeEnum.FAIL, null);
                        }
                    }else {
                        return new ResponseMessageWrapper<LoginResponse>(ResponseCommonCodeEnum.LOGIN_FAIL, "密码错误");
                    }
                }).orElse(new ResponseMessageWrapper<>(ResponseCommonCodeEnum.LOGIN_FAIL, "用户名不存在"));
    }

    public ResponseMessageWrapper logout() {
        TokenContextHolder.getToken()
                .ifPresent(token -> {
                    //移除token
                    redisService.getRedisUserByToken(token)
                            .ifPresent(redisUserData -> redisService.deleteRedisUserByToken(token));
                });
        return new ResponseMessageWrapper<>();
    }
}
