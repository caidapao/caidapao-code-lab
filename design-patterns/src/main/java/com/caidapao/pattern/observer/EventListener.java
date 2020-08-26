package com.caidapao.pattern.observer;

/**
 *
 * 定义了舔狗对 女神发布的事件 要做的处理
 * Time 2020/8/16 16:51
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public interface EventListener {

    void handleShareSick(Event e);

    void handleSharePhotos(Event e);
}
