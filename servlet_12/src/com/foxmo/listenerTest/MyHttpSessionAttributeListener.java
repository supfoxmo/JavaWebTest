package com.foxmo.listenerTest;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    /**
     * 向Session域中存储数据的时候被调用
     * @param se
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("Session data add");
    }

    /**
     * 删除Session域中数据的时候被调用
     * @param se
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("Session data remove");
    }

    /**
     * 替换Session域中的数据的时候被调用
     * @param se
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("Session data replace");
    }
}
