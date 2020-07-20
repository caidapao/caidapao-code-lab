package com.caidapao.pattern.singleton.lazy;

/**
 * Time 2020/7/20 21:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeReflection {

    private static boolean initialized = false;

    private LazyWifeReflection() {
        synchronized (LazyWifeReflection.class) {
            if (!initialized) {
                initialized = true;
            } else {
                throw new RuntimeException("单例模式被破坏");
            }
        }
    }

    public static LazyWifeReflection getInstance() {
        return LazyWifeInnerHolder.LAZY_WIFE_INNER;
    }

    private static class LazyWifeInnerHolder {
        private static final LazyWifeReflection LAZY_WIFE_INNER = new LazyWifeReflection();
    }


}
