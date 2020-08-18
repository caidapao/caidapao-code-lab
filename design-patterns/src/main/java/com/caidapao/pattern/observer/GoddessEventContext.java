package com.caidapao.pattern.observer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听器
 * Time 2020/8/16 12:15
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class GoddessEventContext {

    public static final String HANDLE = "handle";

    private Map<String, GoddessEvent> events = new HashMap<>();

    public void addListener(String eventType, GoddessEventListener target) {
        try {
            String eventName = HANDLE + this.getFirstUpperCase(eventType);
            Method dogHandle = target.getClass().getMethod(eventName, GoddessEvent.class);
            events.put(eventType, new GoddessEvent(eventType, target, dogHandle));
        } catch (Exception e) {
            //do nothing or print exception info
        }
    }

    public void publishEvent(String eventType) {
        GoddessEvent goddessEvent = events.get(eventType);
        if (goddessEvent != null) {
            try {
                goddessEvent.getDogHandle().invoke(goddessEvent.getTarget(), goddessEvent);
            } catch (Exception e) {
                //do nothing or print exception info
            }
        }
    }

    private String getFirstUpperCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
