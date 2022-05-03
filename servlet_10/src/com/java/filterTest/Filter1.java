package com.java.filterTest;

import jakarta.servlet.*;

import java.io.IOException;
//实现jakarta.servlet.Filter接口
//Filter的优先级高于Servlet
//当有多个过滤器时，顺序按照web.xml文件中的配置顺序
//当Filter使用的是注解时，顺序按照类名的大小排列
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器Filter1的init方法执行。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器Filter1的doFilter方法开始执行。。。");

        //执行下一级过滤器，若没有下级过滤器，则执行目标程序servlet
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("过滤器Filter1的doFilter方法执行结束。。。");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器Filter1的destroy方法执行");
    }
}
