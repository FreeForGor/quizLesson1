package ru.umsch.quiz.quiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;


@Configuration
public class MyConfig {

    @Value("${language}")
    private String language;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("greeting");
        ms.setDefaultEncoding("UTF-8");
        ms.setDefaultLocale(Locale.forLanguageTag(language));
        return ms;
    }

}
