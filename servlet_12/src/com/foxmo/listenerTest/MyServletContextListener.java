package com.foxmo.listenerTest;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//ServletContextListener监听器主要监听的是：ServletContext对象的状态
@WebListener
public class MyServletContextListener implements ServletContextListener {
    /**
     * 该方法在ServletContext对象杯创建的时候调用(服务器启动时执行)
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了。。。");
    }

    /**
     * 该方法在ServletContext对象杯创建的时候被调用（服务器关闭时执行）
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了。。。");
    }
}