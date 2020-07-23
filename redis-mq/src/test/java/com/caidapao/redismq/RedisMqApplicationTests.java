package com.caidapao.redismq;

import com.caidapao.redismq.service.TestService;
import com.caidapao.redismq.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisMqApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    void contextLoads() {
        testService.producer(100);
        testService.consumer();
    }

}
