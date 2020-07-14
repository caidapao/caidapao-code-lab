package com.caidapao.pattern.factory.method;

import com.caidapao.pattern.factory.Adidas;
import com.caidapao.pattern.factory.Anta;
import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 18:44
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class AdidasFactory implements BaseFactory{

    @Override
    public Shoe getShoe() {
        System.out.println("我是阿迪达斯工厂，专造阿迪达斯鞋");
        return new Adidas();
    }
}
