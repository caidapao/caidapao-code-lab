package com.caidapao.pattern.singleton.register;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Time 2020/7/21 23:02
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class IOCRegisterSingleton {

    private IOCRegisterSingleton() {
    }

    public static ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {

        if (ioc.containsKey(className)) {
            return ioc.get(className);
        } else {
            try {
                Class<?> clazz = Class.forName(className);
                Object o = clazz.newInstance();
                ioc.put(className, o);
                return o;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
