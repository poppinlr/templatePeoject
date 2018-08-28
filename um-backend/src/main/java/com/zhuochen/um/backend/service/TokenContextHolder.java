package com.zhuochen.um.backend.service;

import com.zhuochen.um.adapter.config.constants.RequestHeaderConstant;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

public class TokenContextHolder {

    public static Optional<String> getToken() {
        return Optional.ofNullable(RequestContextHolder.currentRequestAttributes().getAttribute(RequestHeaderConstant.X_USER_MANAGEMENT_HEADER, RequestAttributes.SCOPE_REQUEST))
                .map(object -> (String) object);
    }

    public static void setToken(String token) {
        RequestContextHolder.currentRequestAttributes().setAttribute(RequestHeaderConstant.X_USER_MANAGEMENT_HEADER, token, RequestAttributes.SCOPE_REQUEST);
    }
}
