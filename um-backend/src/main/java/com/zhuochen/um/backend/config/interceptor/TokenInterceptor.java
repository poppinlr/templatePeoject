package com.zhuochen.um.backend.config.interceptor;

import com.zhuochen.um.adapter.config.constants.RequestHeaderConstant;
import com.zhuochen.um.backend.service.TokenContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TokenContextHolder.setToken(request.getHeader(RequestHeaderConstant.X_USER_MANAGEMENT_HEADER));
        return super.preHandle(request, response, handler);
    }
}
