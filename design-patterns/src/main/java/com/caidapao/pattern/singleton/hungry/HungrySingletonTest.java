package com.caidapao.pattern.singleton.hungry;

import java.util.concurrent.CountDownLatch;

/**
 * 实现了饿汉模式，没有线程安全问题
 * Time 2020/7/15 23:11
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class HungrySingletonTest {


    public static void main(String[] args) {

        int count = 100;
        CountDownLatch downLatch = new CountDownLatch(count);

        /*
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        downLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + ":" + Wife.getWife());

                }
            }.start();
            downLatch.countDown();
        }*/

        //lambda写法
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    downLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":" + HungryWife.getHungryWife());

            }).start();
            downLatch.countDown();
        }


    }
}
