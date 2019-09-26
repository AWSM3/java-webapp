package com.lanit.webapp.listener;

import com.lanit.webapp.filter.I18nFilter;
import com.lanit.webapp.i18n.Translator;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        this.logger.info(
            String.format(getTranslator(httpSessionEvent).translate("text.session-created"), httpSessionEvent.getSession().getId())
        );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        this.logger.info(
            String.format(getTranslator(httpSessionEvent).translate("text.session-destroyed"), httpSessionEvent.getSession().getId())
        );
    }

    public Translator getTranslator(HttpSessionEvent httpSessionEvent) {
        return Translator.getInstance((String)httpSessionEvent.getSession().getAttribute(I18nFilter.LANG_PARAMETER));
    }
}
