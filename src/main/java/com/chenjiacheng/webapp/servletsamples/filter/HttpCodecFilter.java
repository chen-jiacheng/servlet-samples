package com.chenjiacheng.webapp.servletsamples.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/10 00:54
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@WebFilter(filterName = "httpCodecFilter", urlPatterns = {"/*"})
public class HttpCodecFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

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
