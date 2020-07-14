package com.caidapao.pattern.factory.simple;

import com.caidapao.pattern.factory.Adidas;
import com.caidapao.pattern.factory.Anta;
import com.caidapao.pattern.factory.Nike;
import com.caidapao.pattern.factory.Shoe;

/**
 * Time 2020-7-14 20:52
 *
 * @author caidapao
 */
public class SimpleFactory {

    /**
     * 通过特定的参数，获取对应的产品
     * @param brand 品牌
     * @return shoe
     */
    public static Shoe getShoe(String brand) {
        if ("Nike".equals(brand)) {
            return new Nike();
        }
        if ("Anta".equals(brand)) {
            return new Anta();
        }
        if ("Adidas".equals(brand)) {
            return new Adidas();
        }
        return null;
    }
}
