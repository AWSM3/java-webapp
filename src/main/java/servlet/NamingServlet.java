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
    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("type")) {
            case PARAMETER_FIRSTNAME:
                saveAndForward(req, resp, PARAMETER_FIRSTNAME, PARAMETER_MIDDLENAME);
                break;
            case PARAMETER_MIDDLENAME:
                saveAndForward(req, resp, PARAMETER_MIDDLENAME, PARAMETER_LASTNAME);
                break;
            case PARAMETER_LASTNAME:
                save(req, PARAMETER_LASTNAME);
                writeFullname(req, resp);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void save(HttpServletRequest req, String parameter) {
        req.getSession().setAttribute(parameter, req.getParameter("value"));
    }

    private void saveAndForward(HttpServletRequest req, HttpServletResponse resp, String parameter, String to) throws ServletException, IOException {
        save(req, parameter);
        getServletContext().getRequestDispatcher(String.format("/%s.jsp", to)).forward(req, resp);
    }

    private void writeFullname(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        resp.setContentType("text/plain");
        resp.getWriter().write(
                String.format(
                        "Hello, %s %s %s!",
                        session.getAttribute(PARAMETER_FIRSTNAME),
                        session.getAttribute(PARAMETER_MIDDLENAME),
                        session.getAttribute(PARAMETER_LASTNAME)
                )
        );
    }
}
