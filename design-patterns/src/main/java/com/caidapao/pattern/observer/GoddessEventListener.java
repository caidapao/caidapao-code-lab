package com.caidapao.pattern.observer;

/**
 *
 * Time 2020/8/16 16:51
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public interface GoddessEventListener {

    void handleShareSick(GoddessEvent e);

    void handleSharePhotos(GoddessEvent e);
}
