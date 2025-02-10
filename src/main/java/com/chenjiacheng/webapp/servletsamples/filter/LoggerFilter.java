package com.chenjiacheng.webapp.servletsamples.filter;

import com.chenjiacheng.webapp.servletsamples.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * Created by chenjiacheng on 2025/2/10 00:47
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@WebFilter(filterName = "loggerFilter", urlPatterns = {"/*"})
public class LoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggerFilter.init:{}",filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ServletUtils.toHttp(request);
        HttpServletResponse res = ServletUtils.toHttp(response);

        // 拼接请求路径
        String path = req.getContextPath()+req.getServletPath();
        // 记录开始时间
        LocalDateTime startTime = LocalDateTime.now();
        log.info("接口路径:{} 开始处理请求:{}",path,req);
        logRequestDetailsInSingleLine(req);
        try {
            // 继续处理请求
            chain.doFilter(request, response);
            // log.info("接口路径:{} 请求处理完成:{}",path,res);
        } finally {
            // 记录结束时间
            LocalDateTime endTime = LocalDateTime.now();
            // 计算耗时（毫秒）
            long duration = ChronoUnit.MILLIS.between(startTime, endTime);
            // 打印接口耗时
            log.info("接口路径:{} 请求处理完成:{} 耗时:{} ms",path,res,duration);
        }
    }

    @Override
    public void destroy() {
        log.info("LoggerFilter.destroy");
    }


    private void logRequestDetailsInSingleLine(HttpServletRequest httpRequest) throws IOException {
        // Extract relevant request information
        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();
        StringBuilder body = new StringBuilder();
        StringBuilder params = new StringBuilder();

        // Extract parameters for GET requests
        if ("GET".equalsIgnoreCase(method)) {
            Map<String, String[]> parameterMap = httpRequest.getParameterMap();
            parameterMap.forEach((key, values) -> {
                params.append(key).append("=").append(String.join(", ", values)).append("; ");
            });
        }

        // Extract request body for POST requests
        else if ("POST".equalsIgnoreCase(method)) {
            BufferedReader reader = httpRequest.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        // Construct log message
        String logMessage = String.format(
                "Request Method: %s | URI: %s | Parameters: %s | Body: %s",
                method,
                uri,
                params.toString(),
                body.toString()
        );

        // Log the single-line message
        log.info(logMessage);
    }

}
