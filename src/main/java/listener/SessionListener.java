package com.lanit.webapp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {
    private final Logger logger = Logger.getLogger("session.logger");

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        this.logger.info(String.format("Session created (%s). \n", httpSessionEvent.getSession().getId()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        this.logger.info(String.format("Session destroyed (%s). \n", httpSessionEvent.getSession().getId()));
    }
}
