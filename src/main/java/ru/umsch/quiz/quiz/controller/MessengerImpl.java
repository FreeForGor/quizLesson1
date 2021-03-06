package ru.umsch.quiz.quiz.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MessengerImpl implements Messenger {

    private BufferedReader reader;

    private void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String askQuestion(String question) {
        String answer = "";
        try {
            System.out.println("\n" + question);
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Reading error");
        }
        return answer;
    }

    private void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Reader not closed");
        }
    }
}
