package com.chenjiacheng.webapp.servletsamples.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenjiacheng on 2025/2/10 00:48
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class ServletUtils {

    /**
     * Utility method to cast ServletRequest to HttpServletRequest.
     *
     * @param request ServletRequest instance
     * @return HttpServletRequest instance
     * @throws ClassCastException if the cast is not possible
     */
    public static HttpServletRequest toHttp(ServletRequest request) {
        return (HttpServletRequest) request;
    }

    /**
     * Utility method to cast ServletResponse to HttpServletResponse.
     *
     * @param response ServletResponse instance
     * @return HttpServletResponse instance
     * @throws ClassCastException if the cast is not possible
     */
    public static HttpServletResponse toHttp(ServletResponse response) {
        return (HttpServletResponse) response;
    }
}