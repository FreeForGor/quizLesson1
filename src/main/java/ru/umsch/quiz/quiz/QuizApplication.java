package ru.umsch.quiz.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import ru.umsch.quiz.quiz.controller.Messenger;
import ru.umsch.quiz.quiz.controller.MessengerImpl;
import ru.umsch.quiz.quiz.service.CsvParser;
import ru.umsch.quiz.quiz.service.CsvParserImpl;
import ru.umsch.quiz.quiz.service.Tester;


//@PropertySource("classpath:application.yml")
//@Configuration
//@ComponentScan
@EnableAspectJAutoProxy
@SpringBootApplication
public class  QuizApplication {

//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuizApplication.class);
//        Tester tester = context.getBean(Tester.class);
//        tester.testStudents();
//    }
//        @Bean
//        Messenger messenger() {
//            return new MessengerImpl();
//        }
//
//        @Bean
//        CsvParser parser() {
//            return new CsvParserImpl();
//        }

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    }


