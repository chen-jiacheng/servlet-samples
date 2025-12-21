package com.chenjiacheng.webapp.servletsamples.controller;

import com.chenjiacheng.webapp.servletsamples.common.model.Result;
import com.chenjiacheng.webapp.servletsamples.controller.model.RegisterRequest;
import com.chenjiacheng.webapp.servletsamples.controller.model.RegisterResponse;
import com.chenjiacheng.webapp.servletsamples.dao.User;
import com.chenjiacheng.webapp.servletsamples.dao.UserDataHolder;
import com.chenjiacheng.webapp.servletsamples.util.MessageHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenjiacheng on 2025/2/16 23:39
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private final UserDataHolder userDataHolder = UserDataHolder.getInstance();

    @Override
    public void init() throws ServletException {
        userDataHolder.register(new User() {{
            setUsername("chenjiacheng");
            setEmail("chenjiacheng@gmail.com");
            setPassword("admin123");
        }});
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求解析
        RegisterRequest registerRequest = MessageHelper.resolve(req, RegisterRequest.class);
        log.info("request:{}", registerRequest);

        // 业务处理 Mock
        // 2.1 验证
        User existUsername = userDataHolder.findByLogin(registerRequest.getUsername());
        if (null != existUsername) {
            MessageHelper.send(resp, Result.failure("500", "Username is already exist!"));
            return;
        }
        User existEmail = userDataHolder.findByLogin(registerRequest.getEmail());
        if (null != existEmail) {
            MessageHelper.send(resp, Result.failure("500", "Email is already exist!"));
            return;
        }

        // 2.2 注册
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        userDataHolder.register(user);

        // 响应参数封装
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(String.valueOf(user.getId()));
        registerResponse.setUsername(registerRequest.getUsername());

        // 响应发送
        MessageHelper.send(resp, Result.success(registerResponse));
        log.info("response:{}", registerRequest);
    }
}
