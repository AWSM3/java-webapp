package com.lanit.webapp.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    public static final String DEFAULT_BUNDLE = "messages";
    public static final String DEFAULT_LOCALE = Locales.en.name();

    public static Translator instance;

    private Locale locale;
    private ResourceBundle resourceBundle;

    public Translator(String language) {
        if (language == null) {
            language = DEFAULT_LOCALE;
        }

        this.locale = new Locale(language);
        this.resourceBundle = ResourceBundle.getBundle(DEFAULT_BUNDLE, locale);
    }

    public Translator(String language, String bundle) {
        this.locale = new Locale(language);
        this.resourceBundle = ResourceBundle.getBundle(bundle, locale);
    }

    public static  Translator getTranslator(String language) {

        return new Translator(language);
    }

    public static Translator getTranslator(String language, String bundle) {

        return new Translator(language, bundle);
    }

    public static Translator getInstance(String language) {
        if (instance == null) {
            instance = getTranslator(language);
        }

        return instance;
    }

    public String translate(String message) {
        return this.resourceBundle.getString(message);
    }
}
