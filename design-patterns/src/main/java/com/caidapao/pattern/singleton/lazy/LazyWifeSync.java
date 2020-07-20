package com.caidapao.pattern.singleton.lazy;

/**
 * 加上了synchronized解决了并发时产生多个实例，但是有性能问题
 * Time 2020/7/19 11:30
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class LazyWifeSync {

    private LazyWifeSync(){ }

    private static LazyWifeSync lazyWifeSync = null;

    public static synchronized LazyWifeSync getLazyWifeSync(){
        if(lazyWifeSync == null){
            lazyWifeSync = new LazyWifeSync();
        }
        return lazyWifeSync;
    }
}





