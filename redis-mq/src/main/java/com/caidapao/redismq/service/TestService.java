package com.caidapao.redismq.service;

import com.caidapao.redismq.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.CountDownLatch;

/**
 * Time 2020-7-23 14:53
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
@Service
public class TestService {

    public static final String USER = "USER";

    public void producer(int num) {
        Assert.isTrue(num > 0, "num must greater than 0 ");
        CountDownLatch countDownLatch = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(() -> {
                RedisUtil.lPush(USER, String.valueOf(finalI));
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void consumer() {
        while (true){
            try {
                handle();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("handle finish");
        }
    }

    private void handle() {
        String value = (String) RedisUtil.rPop(USER,10);
        if("88".equals(value)){
            System.out.println("==========================");
            int i = 5/0;
        }
    }

}
