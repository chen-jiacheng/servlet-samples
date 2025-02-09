package com.chenjiacheng.webapp.servletsamples.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/10 00:47
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@WebFilter(filterName = "loggerFilter", urlPatterns = {"/*"})
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Log the IP address and current timestamp
        System.out.println("IP " + request.getRemoteAddr() + ", Time " + System.currentTimeMillis());

        // Pass the request
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
