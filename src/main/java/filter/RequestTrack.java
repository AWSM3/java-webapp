package com.lanit.webapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebFilter(urlPatterns={"/*"})
public class RequestTrack implements Filter {
    private final Logger logger = Logger.getLogger("request.logger");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String params = httpRequest.getParameterMap().entrySet().stream()
                .map(entry -> String.format("%s:%s", entry.getKey(), Arrays.toString(entry.getValue())))
                .collect(Collectors.joining(", ", "{", "}"));

        this.logger.info(
                String.format(
                        "\nRequest:\n\t- Method: %s\n\t- URL: %s\n\t- Parameters: %s\n\t- Status: %s\n\t- Body size: %s bytes.\n",
                        httpRequest.getMethod(),
                        httpRequest.getRequestURI(),
                        params,
                        httpResponse.getStatus(),
                        httpRequest.getContentLength() > 0 ? httpRequest.getContentLength() : 0
                )
        );

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
