package com.chenjiacheng.webapp.servletsamples.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by chenjiacheng on 2025/2/10 00:48
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@WebListener   // This annotation is used to declare a class as a listener.
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
        System.out.println("ApplicationListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
        System.out.println("ApplicationListener.contextDestroyed");
    }
}
