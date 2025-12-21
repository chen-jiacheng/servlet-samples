package com.chenjiacheng.webapp.servletsamples.controller;

import com.chenjiacheng.webapp.servletsamples.common.model.Result;
import com.chenjiacheng.webapp.servletsamples.util.MessageHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/16 23:39
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 请求解析
        log.info("request:{}", req);

        // 业务处理 Mock
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // 可选：删除客户端存储的JSESSIONID Cookie，因为Session已经失效
        // 注意：这可能会影响到同一浏览器中访问同一应用的其他标签页的Session
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0); // 立即删除
                    cookie.setPath("/"); // 设置与创建时相同的路径
                    resp.addCookie(cookie);
                    break;
                }
            }
        }

        // 响应发送
        MessageHelper.send(resp, Result.success());
        log.info("response:{}", resp);
    }
}
