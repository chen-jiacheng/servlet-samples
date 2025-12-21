package com.chenjiacheng.webapp.servletsamples.util;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * Created by chenjiacheng on 2025/12/21 11:36
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class MessageHelper {

    public static <T> T resolve(HttpServletRequest request,Class<T> clazz) throws IOException {
        if(request == null || clazz == null){
            throw new NullPointerException();
        }
        BufferedReader reader = request.getReader();
        String json = reader.lines().collect(Collectors.joining());
        return JSON.parseObject(json,clazz);
    }

    public static <T> void send(HttpServletResponse response, T data) throws IOException {
        if(response == null || data == null){
            throw new NullPointerException();
        }
        String json = JSON.toJSONString(data);
        if(StringUtils.isEmpty(json)){
            return;
        }
        // 设置响应头
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write(json);
    }

}
