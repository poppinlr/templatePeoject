package com.zhuochen.um.backend;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;

@RunWith(JUnit4.class)
@Log4j2
public class BasicFunctionTest {


    @Test
    public void testLocalTime() {
        log.info("hello: "+LocalDateTime.now().toString());
    }
}
