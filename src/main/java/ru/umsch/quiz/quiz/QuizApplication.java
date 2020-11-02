package ru.umsch.quiz.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.umsch.quiz.quiz.service.Tester;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {

        SpringApplication.run(QuizApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Tester tester = context.getBean(Tester.class);
        tester.testStudents("questions.csv");
    }

}
