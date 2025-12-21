package com.chenjiacheng.webapp.servletsamples.controller.model;

import java.util.StringJoiner;

/**
 * Created by chenjiacheng on 2025/12/18 00:37
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class RegisterResponse {

    private String userId;

    private String username;

    public RegisterResponse() {
    }

    public RegisterResponse(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterResponse.class.getSimpleName() + "[", "]")
                .add("userId='" + userId + "'")
                .add("username='" + username + "'")
                .toString();
    }
}
