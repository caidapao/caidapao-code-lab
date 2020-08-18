package com.caidapao.pattern.observer;

/**
 *
 * 观察者对被观察者发布事件后的处理（女神发布了事件，舔狗的处理）
 * Time 2020/8/16 11:57
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class Dog implements GoddessEventListener{

    public void handleShareSick(GoddessEvent e){
        System.out.println("=========================优秀舔狗，行动暖心=========================");
        System.out.println("舔狗扛着一桶农夫山泉桶装水敲响了女神家的门，留下一句\"多喝沸水\"后，潇洒离去~");
    }

    public void handleSharePhotos(GoddessEvent e) {
        System.out.println("=========================优秀舔狗，不吝称赞=========================");
        System.out.println("舔狗以迅雷不及掩耳盗铃儿响叮当仁不让之势评论一句：拍的真美，但还是本人更好看");
    }


}
