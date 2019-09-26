package com.lanit.webapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class I18nFilter implements Filter {
    public static final String LANG_PARAMETER = "lang";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        if (httpRequest.getParameter(LANG_PARAMETER) != null) {
            httpRequest.getSession().setAttribute(LANG_PARAMETER, httpRequest.getParameter(LANG_PARAMETER));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
