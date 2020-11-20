package ru.umsch.quiz.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;


@EnableAspectJAutoProxy
@SpringBootApplication
public class QuizApplication {


    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

}


