package com.caidapao.pattern.factory.method;

/**
 * 工厂方法模式实现
 * Time 2020-6-29 20:53
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        BaseFactory baseFactory = new NikeFactory();
        System.out.println(baseFactory.getShoe().getShoeName());
    }
}
