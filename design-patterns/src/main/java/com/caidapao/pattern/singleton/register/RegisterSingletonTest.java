package com.caidapao.pattern.singleton.register;

import com.caidapao.pattern.singleton.lazy.LazyWifeInnerTest;
import com.caidapao.pattern.singleton.destoryer.ReflectDestroyerTest;
import com.caidapao.pattern.singleton.lazy.LazyWifeSyncTest;
import com.caidapao.pattern.singleton.lazy.LazyWifeTest;

/**
 * 注册登记式单例模式实现（Spring 中的ioc容器也是这样实现）
 * Time 2020/7/21 23:02
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class RegisterSingletonTest {


    public static void main(String[] args) {

        System.out.println(RegisterSingleton.getBean(LazyWifeTest.class.getName()));
        System.out.println(RegisterSingleton.getBean(LazyWifeInnerTest.class.getName()));
        System.out.println(RegisterSingleton.getBean(ReflectDestroyerTest.class.getName()));
        System.out.println(RegisterSingleton.getBean(LazyWifeSyncTest.class.getName()));
    }

}
