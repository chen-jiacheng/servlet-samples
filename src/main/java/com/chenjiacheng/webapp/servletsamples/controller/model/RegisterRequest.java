package com.chenjiacheng.webapp.servletsamples.controller.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by chenjiacheng on 2025/12/18 00:36
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class RegisterRequest implements Serializable {

    private String username;

    private String email;

    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterRequest.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("email='" + email + "'")
                .add("password='******'")
                .toString();
    }
}
