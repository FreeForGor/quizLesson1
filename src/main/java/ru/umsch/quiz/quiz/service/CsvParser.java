package ru.umsch.quiz.quiz.service;

import java.util.Map;


public interface CsvParser {
    Map<String,String> parseQuestionsFromFile(String fileName);
}
