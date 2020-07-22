package com.caidapao.pattern.singleton.lazy;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉模式基础，有并发问题，会产生多个Wife（渣男）
 * Time 2020/7/15 23:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeTest {


    public static void main(String[] args) {
        int count = 100;
        CountDownLatch downLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    downLatch.await();
                    System.out.println(System.currentTimeMillis() + ":" + LazyWife.getLazyWife());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
            downLatch.countDown();
        }

    }
}
