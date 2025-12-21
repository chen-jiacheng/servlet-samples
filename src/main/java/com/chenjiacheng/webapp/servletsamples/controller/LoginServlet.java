package com.chenjiacheng.webapp.servletsamples.controller;

import com.chenjiacheng.webapp.servletsamples.common.model.Result;
import com.chenjiacheng.webapp.servletsamples.controller.model.LoginRequest;
import com.chenjiacheng.webapp.servletsamples.controller.model.LoginResponse;
import com.chenjiacheng.webapp.servletsamples.dao.User;
import com.chenjiacheng.webapp.servletsamples.dao.UserDataHolder;
import com.chenjiacheng.webapp.servletsamples.util.MessageHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/16 23:39
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDataHolder userDataHolder = UserDataHolder.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求解析
        LoginRequest loginRequest = MessageHelper.resolve(req, LoginRequest.class);
        log.info("request:{}", loginRequest);

        // 业务处理 Mock
        // 2.1 验证
        User user = userDataHolder.findByLogin(loginRequest.getLogin());
        if (null == user) {
            MessageHelper.send(resp, Result.failure("500", "Username or Email is not exist!"));
            return;
        }
        // 2.2 生成session
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);
        session.setAttribute("isLogin",true);

        // 响应处理
        // 3.1 响应参数封装
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(user.getId());
        loginResponse.setUsername(user.getUsername());
        loginResponse.setEmail(user.getEmail());
        // 3.2 响应发送
        MessageHelper.send(resp, Result.success(loginResponse));
        log.info("response:{}", loginResponse);
    }
}
