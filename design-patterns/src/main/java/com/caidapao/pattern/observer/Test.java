package com.caidapao.pattern.observer;

/**
 * Time 2020/8/16 13:03
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class Test {

    public static void main(String[] args) {
        //得有一只舔狗（观察者）
        Dog dog = new Dog();
        //得有一个女神（被观察者）
        Goddess goddess = new Goddess();
        //女神的朋友圈舔狗得能看的到才行（监听器，必须持有观察者和事件类型）
        goddess.addListener(GoddessEventType.SHARE_PHOTOS, dog);
        goddess.addListener(GoddessEventType.SHARE_SICK, dog);
        //女神分享照片了（被观察者发布事件）
        goddess.sharePhotos();
        System.out.println();
        //女神分享透露自己生病了（被观察者发布事件）
        goddess.shareSick();
    }
}
