package com.chenjiacheng.webapp.servletsamples.servlet;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Slf4j
@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message = "hello world";

    @Override
    public void init() {
        log.info("HelloServlet.init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("HelloServlet.doGet:request:{}",request);

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        log.info("HelloServlet.doGet:{}",message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("HelloServlet.doPost:request:{}",req);

        // Step 1: Set the response content type to JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Step 2: Construct the JSON response
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "200");
        jsonObject.put("msg", "success");
        jsonObject.put("data", "{ \"message\": \"Hello, World!\", \"status\": \"success\" }");

        // Step 3: Write the JSON data to the response
        PrintWriter out = resp.getWriter();
        out.print(jsonObject.toJSONString());
        out.flush();
    }

    @Override
    public void destroy() {
        log.info("HelloServlet.destroy");
    }
}