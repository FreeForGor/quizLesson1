package ru.umsch.quiz.quiz.controller;


public interface Messenger {

    void askQuestion(String question);
    String answerQuestion();
    void textMessage(String message);
}
