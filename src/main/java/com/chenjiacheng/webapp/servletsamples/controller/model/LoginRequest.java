package com.chenjiacheng.webapp.servletsamples.controller.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by chenjiacheng on 2025/12/18 00:37
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class LoginRequest implements Serializable {

    private String login;

    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoginRequest.class.getSimpleName() + "[", "]")
                .add("login='" + login + "'")
                .add("password='******'")
                .toString();
    }
}
