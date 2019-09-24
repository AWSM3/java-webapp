package com.lanit.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/naming")
public class NamingServlet extends HttpServlet {
    public static final String TEXT_PLAIN = "text/plain";
    public static final String HELLO_STRING = "Hello, %s %s %s!";

    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";

    public static final String LASTNAME_JSP = "/lastname.jsp";
    public static final String MIDDLENAME_JSP = "/middlename.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(req.getParameter("type"), req.getParameter("value"));

        switch (req.getParameter("type")) {
            case PARAMETER_FIRSTNAME:
                getServletContext().getRequestDispatcher(MIDDLENAME_JSP).forward(req, resp);
                break;
            case PARAMETER_MIDDLENAME:
                getServletContext().getRequestDispatcher(LASTNAME_JSP).forward(req, resp);
                break;
            case PARAMETER_LASTNAME:
                writeFullname(req, resp);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void writeFullname(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        resp.setContentType(TEXT_PLAIN);
        resp.getWriter().write(
                String.format(
                        HELLO_STRING,
                        session.getAttribute(PARAMETER_FIRSTNAME),
                        session.getAttribute(PARAMETER_MIDDLENAME),
                        session.getAttribute(PARAMETER_LASTNAME)
                )
        );
    }
}
