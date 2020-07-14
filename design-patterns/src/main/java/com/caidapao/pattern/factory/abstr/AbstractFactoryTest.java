package com.caidapao.pattern.factory.abstr;

/**
 * 抽象工厂模式实现
 * Time 2020-6-29 20:56
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        ShoeFactory shoeFactory = new ShoeFactory();
        System.out.println(shoeFactory.getAdidasShoe().getShoeName());
    }
}
