package com.caidapao.pattern.factory.method;

import com.caidapao.pattern.factory.Nike;
import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 18:44
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class NikeFactory implements BaseFactory{

    @Override
    public Shoe getShoe() {
        System.out.println("我是耐克工厂，专造耐克鞋");
        return new Nike();
    }
}
