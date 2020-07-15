package com.caidapao.pattern.singleton.lazy;

import java.util.concurrent.CountDownLatch;

/**
 * Time 2020/7/15 23:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazySingletonTest {


    public static void main(String[] args) {
        int count = 50;
        CountDownLatch downLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    downLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":" + LazyWife.getLazyWife());

            }).start();
            downLatch.countDown();
        }

    }
}
