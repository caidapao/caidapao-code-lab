package com.caidapao.pattern.observer;

import java.util.HashMap;
import java.util.Map;

/**
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
            events.put(eventType, new GoddessEvent(eventType, target, target.getClass().getMethod(HANDLE + this.getFirstUpperCase(eventType),GoddessEvent.class)));
        } catch (Exception e) {
            //do nothing
            e.printStackTrace();
        }
    }

    public void publishEvent(String eventType) {
        GoddessEvent goddessEvent = events.get(eventType);
        if (goddessEvent != null) {
            try {
                goddessEvent.getDogHandle().invoke(goddessEvent.getTarget(),goddessEvent);
            } catch (Exception e) {
                //do nothing
                e.printStackTrace();
            }
        }
    }

    private String getFirstUpperCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
