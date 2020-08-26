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
        //钢铁直男强势加入
        IronMan ironMan = new IronMan();
        //得有一个女神（被观察者）
        Goddess goddess = new Goddess();
        //女神通过父类的朋友圈addListener方法把事件类型和舔狗关联起来
        goddess.addListener(GoddessEventType.SHARE_PHOTOS, dog);
        goddess.addListener(GoddessEventType.SHARE_SICK, ironMan);
        //女神分享照片了（被观察者发布事件）
        goddess.sharePhotos();
        //只是换个行
        System.out.println();
        //女神分享透露自己生病了（被观察者发布事件）
        goddess.shareSick();
    }

}
