package com.foxmo.listenerTest;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    /**
     * Session对象被创建的时候调用
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session对象被创建了。。。");
    }

    /**
     * Session对象被销毁的时候调用
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session对象被销毁l。。。");
    }
}
