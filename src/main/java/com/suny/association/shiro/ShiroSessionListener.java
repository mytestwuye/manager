package com.suny.association.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comments:    shiro会话监听器
 * Author:   孙建荣
 * Create Date: 2017/05/01 18:14
 */
class ShiroSessionListener implements SessionListener {
    private static final Logger looger = LoggerFactory.getLogger(ShiroSessionListener.class);

    @Override
    public void onStart(Session session) {
        looger.info("会话开始" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        looger.info("会话停止" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        looger.info("会话过期" + session.getId());
    }
}
