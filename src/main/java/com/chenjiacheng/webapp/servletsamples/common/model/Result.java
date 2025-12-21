package com.chenjiacheng.webapp.servletsamples.common.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by chenjiacheng on 2025/12/18 00:38
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T date;

    public Result() {
    }

    public Result(String code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("msg='" + msg + "'")
                .add("date=" + date)
                .toString();
    }

    public static <T> Result<T> failure(String code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>("200", "OK", data);
    }

    public static <T> Result<T> success() {
        return new Result<>("200", "OK", null);
    }
}
