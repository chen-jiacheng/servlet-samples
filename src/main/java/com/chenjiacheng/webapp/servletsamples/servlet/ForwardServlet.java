package com.chenjiacheng.webapp.servletsamples.servlet;

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
@WebServlet(name = "forwardServlet", value = "/forward")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        super.getServletContext().getRequestDispatcher("/"+url).forward(req, resp);
    }
}
