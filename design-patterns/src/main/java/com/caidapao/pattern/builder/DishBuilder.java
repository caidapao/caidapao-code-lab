package com.caidapao.pattern.builder;

/**
 * Time 2020-8-8 9:51
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class DishBuilder {

    private Dish tomatoOmelette = new Dish();

    private String salt = "半勺盐";

    private String egg;

    private String oil;

    private String tomatoes;

    private String sugar;


    public DishBuilder addOil(String oil) {
        this.oil = oil;
        return this;
    }

    public DishBuilder addTomatoes(String tomatoes) {
        this.tomatoes = tomatoes;
        return this;
    }

    public DishBuilder addEgg(String egg) {
        this.egg = egg;
        return this;
    }

    public DishBuilder addSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public DishBuilder addSugar(String sugar) {
        this.sugar = sugar;
        return this;
    }

    public Dish build() {
        System.out.println("热锅");
        System.out.println("热锅完毕，放油");
        tomatoOmelette.setOil(oil);
        if (egg == null) {
            System.out.println("没鸡蛋做什么西红柿炒鸡蛋？直接生吃西红柿得了");
            return null;
        }
        System.out.println("放" + egg);
        tomatoOmelette.setEgg(egg);
        System.out.println("放" + tomatoes);
        tomatoOmelette.setTomatoes(tomatoes);
        System.out.println("放" + salt);
        tomatoOmelette.setSalt(salt);
        if (sugar != null) {
            System.out.println("有些人喜欢放点糖，但是加不加都没有太大影响");
            tomatoOmelette.setSugar(sugar);
        }
        System.out.println("得到一盘西红柿炒蛋");
        return tomatoOmelette;
    }


}
