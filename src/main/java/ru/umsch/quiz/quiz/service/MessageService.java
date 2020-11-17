package ru.umsch.quiz.quiz.service;

import java.util.Locale;


public interface MessageService {
    String getQuestionsFileName();

    String getMessage(String messageKey, Object[] objects);

    void setLocale(Locale locale);
}
