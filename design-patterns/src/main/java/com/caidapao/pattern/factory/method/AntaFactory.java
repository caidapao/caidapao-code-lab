package com.caidapao.pattern.factory.method;

import com.caidapao.pattern.factory.Anta;
import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 18:44
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class AntaFactory implements BaseFactory{

    @Override
    public Shoe getShoe() {
        System.out.println("我是安踏工厂，专造安踏鞋");
        return new Anta();
    }
}
