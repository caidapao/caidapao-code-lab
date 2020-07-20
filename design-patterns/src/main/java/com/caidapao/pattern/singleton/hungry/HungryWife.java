package com.caidapao.pattern.singleton.hungry;

/**
 *
 * Time 2020/7/15 23:11
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class HungryWife {

    private HungryWife(){}

    private static final HungryWife HUNGRY_WIFE = new HungryWife();

    public static HungryWife getHungryWife() {
        return HUNGRY_WIFE;
    }
}
