package com.caidapao.pattern.singleton.lazy;

/**
 * Time 2020/7/20 21:32
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeInner {


    private LazyWifeInner() { }

    public static LazyWifeInner getInstance() {
        return LazyWifeInnerHolder.LAZY_WIFE_INNER;
    }

    private static class LazyWifeInnerHolder {
        private static final LazyWifeInner LAZY_WIFE_INNER = new LazyWifeInner();
    }


}
