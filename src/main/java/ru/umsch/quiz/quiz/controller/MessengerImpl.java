package ru.umsch.quiz.quiz.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class MessengerImpl implements Messenger {

    private BufferedReader reader ;

    private void init()  {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }



    @Override
    public void askQuestion(String question) {
        System.out.println("\n" + question);
    }


    @Override
    public String answerQuestion(){
        init();
        String answer = "";
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Reading error");
        }
        return answer;
    }

    @Override
    public void textMessage(String message) {
        System.out.println(message);
    }


    private void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Reader not closed");
        }
    }
}
