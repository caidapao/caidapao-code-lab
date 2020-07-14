package com.caidapao.pattern.factory.simple;

/**
 * Created by caidapao on 2020-7-14
 * Time 14:20
 * Address https://today.caidapao.com
 */
public class SimpleFactoryTest {


    public static void main(String[] args) {
        System.out.println(SimpleFactory.getShoe("Nike").getShoeName());
    }
}
