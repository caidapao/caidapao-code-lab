package com.caidapao.pattern.factory.simple;

/**
 * 简单工厂模式实现
 * Time 2020-7-14 14:20
 * Address https://today.caidapao.com
 * @author caidapao
 */
public class SimpleFactoryTest {


    public static void main(String[] args) {
        System.out.println(SimpleFactory.getShoe("Nike").getShoeName());
    }
}
