package com.java.filterTest;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器Filter2的doFilter方法开始执行。。。");

        //执行下一级过滤器，若没有下级过滤器，则执行目标程序servlet
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("过滤器Filter2的doFilter方法执行结束。。。");
    }

    @Override
    public void destroy() {
    }
}
