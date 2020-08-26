package com.caidapao.pattern.observer;

/**
 *
 * 女神本人，会发朋友圈（发布事件）
 * Time 2020/8/16 12:59
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class Goddess extends EventContext {

    public void shareSick() {
        System.out.println("女神在朋友圈说自己生病了");
        this.publishEvent(GoddessEventType.SHARE_SICK);
    }

    public void sharePhotos() {
        System.out.println("女神在朋友圈分享了自拍");
        this.publishEvent(GoddessEventType.SHARE_PHOTOS);
    }
}
