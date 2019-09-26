package com.lanit.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public static final String NAME_PARAMETER = "name";
    public static final String CLASS_PARAMETER = "class";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(CLASS_PARAMETER, getClass().getSimpleName());
        request.setAttribute(NAME_PARAMETER, request.getParameter(NAME_PARAMETER));
        getServletContext().getRequestDispatcher("/greet.jsp").forward(request, response);
    }
}
