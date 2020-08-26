package com.caidapao.pattern.observer;

import java.lang.reflect.Method;

/**
 * 被观察者（女神发布的事件）
 * Time 2020/8/16 11:57
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class Event {

    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 处理事件者（类似于朋友圈对谁可见）
     */
    private EventListener target;
    /**
     * 舔狗对事件的处理（事件的回调或者说是处理）
     */
    private Method dogHandle;


    public Event(String eventType, EventListener target, Method dogHandle) {
        this.eventType = eventType;
        this.target = target;
        this.dogHandle = dogHandle;
    }

    public EventListener getTarget() {
        return target;
    }

    public void setTarget(EventListener target) {
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
