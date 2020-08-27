package com.caidapao.pattern.observer;

/**
 * 钢铁直男
 * Time 2020-8-26 20:35
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class IronMan implements EventListener{

    public void handleShareSick(Event e){
        System.out.println("=========================钢铁直男，真情实意=========================");
        System.out.println("钢铁直男秒回：有病就去医院，还搁这发朋友圈？");
    }

    public void handleSharePhotos(Event e) {
        System.out.println("=========================钢铁直男，观察细微=========================");
        System.out.println("钢铁直男以迅雷不及掩耳盗铃儿响叮当仁不让之势评论了一句：P的墙都变形了，好意思发？");
    }

}
