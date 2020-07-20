package com.caidapao.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * Time 2020/7/20 21:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeReflectionTest {


    public static void main(String[] args) {
//        try {
//
//            Class<?> clazz = Class.forName("com.caidapao.pattern.singleton.lazy.LazyWifeInner");
//
//            Constructor<?> c = clazz.getDeclaredConstructor();
//            c.setAccessible(true);
//            LazyWifeInner o = (LazyWifeInner) c.newInstance();
//            System.out.println(o);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {

            Class<?> clazz = Class.forName("com.caidapao.pattern.singleton.lazy.LazyWifeInner");
            Constructor<?>[] cs = clazz.getDeclaredConstructors();
            for (Constructor c : cs) {
                c.setAccessible(true);
                LazyWifeInner o = (LazyWifeInner) c.newInstance();
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
