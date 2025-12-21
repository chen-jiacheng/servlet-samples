package com.chenjiacheng.webapp.servletsamples.controller.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by chenjiacheng on 2025/12/18 00:37
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class LoginResponse implements Serializable {

    private Long id;

    private String username;

    private String email;

    public LoginResponse() {
    }

    public LoginResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", LoginResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
