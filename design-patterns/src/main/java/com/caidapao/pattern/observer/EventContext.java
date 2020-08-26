package com.caidapao.pattern.observer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件上下文 (类似于微信朋友圈)
 * Time 2020/8/16 12:15
 *
 * @author caidapao
 */
public class EventContext {

    public static final String HANDLE = "handle";

    private Map<String, Event> events = new HashMap<>();

    public void addListener(String eventType, EventListener target) {
        try {
            String eventName = HANDLE + this.getFirstUpperCase(eventType);
            Method dogHandle = target.getClass().getMethod(eventName, Event.class);
            events.put(eventType, new Event(eventType, target, dogHandle));
        } catch (Exception e) {
            //do nothing or do everything you want
        }
    }

    public void publishEvent(String eventType) {
        Event event = events.get(eventType);
        if (event != null) {
            try {
                event.getDogHandle().invoke(event.getTarget(), event);
            } catch (Exception e) {
                //do nothing or do everything you want
            }
        }
    }

    private String getFirstUpperCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }









}
