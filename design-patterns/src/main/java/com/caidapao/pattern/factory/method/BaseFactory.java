package com.caidapao.pattern.factory.method;

import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 18:43
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public interface BaseFactory {

    /**
     * 获取鞋
     * @return 鞋子
     */
    Shoe getShoe();
}
