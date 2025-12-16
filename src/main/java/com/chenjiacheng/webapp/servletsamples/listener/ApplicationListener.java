package com.chenjiacheng.webapp.servletsamples.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by chenjiacheng on 2025/2/10 00:48
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ApplicationListener.contextInitialized:{}",sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ApplicationListener.contextDestroyed:{}",sce);
    }
}
