package com.caidapao.pattern.singleton.lazy;

import com.caidapao.pattern.singleton.hungry.HungryWife;

/**
 * Time 2020/7/15 23:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeSyncTest {


    public static void main(String[] args) {
        int count = 500000000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
           HungryWife.getHungryWife();
        }
        System.out.println("HungryWife获取" + count + "次实例,总耗时：" + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            LazyWifeSync.getLazyWifeSync();
        }
        System.out.println("LazyWifeSync获取" + count + "次实例,总耗时：" + (System.currentTimeMillis() - start1));
    }
}
