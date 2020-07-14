package com.caidapao.pattern.factory.abstr;

import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 19:00
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public abstract class AbstractFactory {

    public abstract Shoe getNikeShoe();

    public abstract Shoe getAntaShoe();

    public abstract Shoe getAdidasShoe();
}
