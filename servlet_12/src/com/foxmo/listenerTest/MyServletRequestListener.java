package com.foxmo.listenerTest;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    /**
     * Request对象销毁的时候调用
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request对象销毁了。。。");
    }

    /**
     * Request对象创建的时候调用
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request对象创建了。。。");
    }
}
