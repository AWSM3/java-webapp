package com.lanit.webapp.filter;

import com.lanit.webapp.http.ContentCaptureResponse;
import com.lanit.webapp.i18n.Translator;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebFilter(urlPatterns={"/*"})
public class RequestTrack implements Filter {
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        ContentCaptureResponse contentCaptureResponse = new ContentCaptureResponse(httpResponse);

        String params = httpRequest.getParameterMap().entrySet().stream()
                .map(entry -> String.format("%s:%s", entry.getKey(), Arrays.toString(entry.getValue())))
                .collect(Collectors.joining(", ", "{", "}"));

        filterChain.doFilter(servletRequest, contentCaptureResponse);
        String content = contentCaptureResponse.getContent();

        this.logger.info(
                String.format(
                        getTranslator(httpRequest).translate("text.request-track-message"),
                        httpRequest.getMethod(),
                        httpRequest.getRequestURI(),
                        params,
                        httpResponse.getStatus(),
                        content.length()
                )
        );

        servletResponse.getOutputStream().write(content.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void destroy() {}

    public Translator getTranslator(HttpServletRequest httpRequest) {
        return Translator.getInstance((String)httpRequest.getSession().getAttribute(I18nFilter.LANG_PARAMETER));
    }
}
