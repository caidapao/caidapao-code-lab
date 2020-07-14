package com.caidapao.pattern.factory.abstr;

import com.caidapao.pattern.factory.Shoe;
import com.caidapao.pattern.factory.method.AdidasFactory;
import com.caidapao.pattern.factory.method.AntaFactory;
import com.caidapao.pattern.factory.method.NikeFactory;

/**
 * Time 2020-7-14 19:01
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class ShoeFactory extends AbstractFactory{


    @Override
    public Shoe getNikeShoe() {
        return new NikeFactory().getShoe();
    }

    @Override
    public Shoe getAntaShoe() {
        return new AntaFactory().getShoe();
    }

    @Override
    public Shoe getAdidasShoe() {
        return new AdidasFactory().getShoe();
    }

}
