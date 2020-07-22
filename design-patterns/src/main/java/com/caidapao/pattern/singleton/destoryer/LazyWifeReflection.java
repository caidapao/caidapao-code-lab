package com.caidapao.pattern.singleton.destoryer;

/**
 * Time 2020/7/20 21:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeReflection {


    private LazyWifeReflection() {
        if (LazyWifeInnerHolder.LAZY_WIFE_INNER != null) {
            throw new RuntimeException("单例模式已经被暴力侵犯");
        }
    }

    public static LazyWifeReflection getInstance() {
        return LazyWifeInnerHolder.LAZY_WIFE_INNER;
    }

    private static class LazyWifeInnerHolder {
        private static final LazyWifeReflection LAZY_WIFE_INNER = new LazyWifeReflection();
    }


}
