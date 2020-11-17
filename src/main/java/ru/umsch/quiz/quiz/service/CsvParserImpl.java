package ru.umsch.quiz.quiz.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


@Component
public class CsvParserImpl implements CsvParser {

    public Map<String, String> parseQuestionsFromFile(String fileName) {


        Map<String, String> result = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + fileName)))) {

            while(reader.ready()) {
                String[] arr = reader.readLine().split(",");
                String question = arr[0];
                String answer = arr[1];
                result.put(question, answer.substring(1, arr[1].length() - 1));
            }
        } catch (IOException e) {
            System.out.println("Parsing error");
        }
        return result;
    }
}
