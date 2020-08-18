package com.caidapao.pattern.observer;

import java.lang.reflect.Method;

/**
 * 被观察者（女神发布的事件）
 * Time 2020/8/16 11:57
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class GoddessEvent {

    /**
     * 朋友圈类型（事件类型）
     */
    private String eventType;
    /**
     * 朋友圈类型
     */
    private GoddessEventListener target;
    /**
     * 朋友圈类型
     */
    private Method dogHandle;


    public GoddessEvent(String eventType, GoddessEventListener target, Method dogHandle) {
        this.eventType = eventType;
        this.target = target;
        this.dogHandle = dogHandle;
    }

    public GoddessEventListener getTarget() {
        return target;
    }

    public void setTarget(GoddessEventListener target) {
        this.target = target;
    }

    public Method getDogHandle() {
        return dogHandle;
    }

    public void setDogHandle(Method dogHandle) {
        this.dogHandle = dogHandle;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
