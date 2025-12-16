package com.chenjiacheng.webapp.servletsamples.servlet;

import com.alibaba.fastjson.JSON;
import com.chenjiacheng.webapp.servletsamples.constant.enums.ContentType;
import com.sun.xml.internal.messaging.saaj.util.MimeHeadersUtil;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;
import com.sun.xml.internal.ws.encoding.ContentTypeImpl;
import lombok.extern.slf4j.Slf4j;
import sun.net.www.MimeEntry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/16 23:40
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebServlet(name = "LifecycleServlet", value = "/lifecycle")
public class LifecycleServlet extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        log.info("LifecycleServlet.init:{}",config);
    }

    @Override
    public void destroy() {
        log.info("LifecycleServlet.destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", ContentType.APPLICATION_JSON.getValue());
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(JSON.toJSONBytes(config));
        outputStream.flush();
    }
}