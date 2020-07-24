package com.caidapao.pattern.singleton.destoryer;

import java.io.Serializable;

/**
 * Time 2020/7/20 21:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class SerialDestroyer implements Serializable {


    private SerialDestroyer() {
//        if (LazyWifeInnerHolder.LAZY_WIFE_INNER != null) {
//            throw new RuntimeException("单例模式已经被暴力侵犯");
//        }
    }

    public static SerialDestroyer getInstance() {
        return LazyWifeInnerHolder.LAZY_WIFE_INNER;
    }

    private static class LazyWifeInnerHolder {
        private static final SerialDestroyer LAZY_WIFE_INNER = new SerialDestroyer();
    }

    private Object readResolve() {
        return getInstance();
    }


}
