package com.caidapao.pattern.observer;

/**
 * Time 2020/8/16 13:03
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class Test {

    public static void main(String[] args) {
        Dog dog = new Dog();

        Goddess goddess = new Goddess();
        goddess.addListener(GoddessEventType.SHARE_PHOTOS, dog);
        goddess.addListener(GoddessEventType.SHARE_SICK, dog);

        goddess.sharePhotos();
        System.out.println();
        goddess.shareSick();
    }
}
