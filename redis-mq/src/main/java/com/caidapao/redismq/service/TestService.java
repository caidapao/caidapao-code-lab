package com.caidapao.redismq.service;

import com.caidapao.redismq.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
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

    /**
     * 模拟生产者
     *
     * @param num push消息到list的数量
     */
    public void producer(int num) {
        Assert.isTrue(num > 0, "num must greater than 0 ");
        CountDownLatch countDownLatch = new CountDownLatch(num);

        //这里不用多线程也完全没问题
        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(() -> {
                RedisUtil.lPush(USER, String.valueOf(finalI));
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("生产完成");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 模拟消费者消费队列中的消息
     */
    public void consumer() {
        System.out.println("开始消费");
        while (true) {
            try {
                handleBusinessWork();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 模拟处理业务
     */
    private void handleBusinessWork() {
        //redisTemplate的pop方法都是
        String value = (String) RedisUtil.rPop(USER, 10);
        if ("88".equals(value)) {
            System.out.println("==========================");
            //模拟处理业务时失败的场景。当前pop出来的这条就丢失了，因为没有ack确认
            int i = 5 / 0;
        }
        System.out.println("消费" + value + "完成");
    }

}
