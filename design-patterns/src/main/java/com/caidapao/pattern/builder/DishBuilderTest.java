package com.caidapao.pattern.builder;

/**
 * Time 2020-8-8 11:11
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class DishBuilderTest {

    public static void main(String[] args) {

        Dish dish = new Dish();
        dish.setEgg("三个蛋");
        dish.setSugar("一勺糖");
        dish.setSalt("一勺盐");
        dish.setOil("一勺油");
        dish.setTomatoes("两个西红柿");


        Dish myDish = new DishBuilder()
                .addTomatoes("一勺糖")
                .addEgg("三个蛋")
                .addOil("一勺油")
                .addSalt("一勺盐").build();

    }
}
