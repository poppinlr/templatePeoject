package com.zhuochen.um.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/hello")
    public String hello() {
        return "success";
    }
//    RouterFunction function = RouterFunctions.route(
//            RequestPredicates.GET("/hello"),
//            request -> ServerResponse.ok()
//                    .build()
//    );

    @GetMapping(value = "/insert")
    public String insert() {
        stringRedisTemplate.opsForValue().set("user", "Token", 10, TimeUnit.SECONDS);
        return "user";
    }

    @GetMapping(value = "/get")
    public String get() {
        return stringRedisTemplate.opsForValue().get("user");
    }
}
