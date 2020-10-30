package ru.umsch.quiz.quiz;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.umsch.quiz.quiz.service.Tester;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Tester tester = context.getBean(Tester.class);
        tester.testStudents("questions.csv");
    }
}
