package com.caidapao.pattern.singleton.lazy;

/**
 *
 * Time 2020/7/15 23:33
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWife {

    private LazyWife() {}

    private static LazyWife lazyWife = null;

    public static LazyWife getLazyWife() {
        if (lazyWife == null) {
            lazyWife = new LazyWife();
        }
        return lazyWife;
    }
}
