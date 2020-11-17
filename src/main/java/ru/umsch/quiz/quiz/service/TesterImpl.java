package ru.umsch.quiz.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.umsch.quiz.quiz.controller.Messenger;
import ru.umsch.quiz.quiz.mod.TestRes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service

public class TesterImpl implements Tester {

    private CsvParser parser;
    private Messenger messenger;
    private MessageService messageService;
    private List<TestRes> testResults = new ArrayList<>();

    @Autowired
    public TesterImpl(CsvParser parser, MessageService messageService, Messenger messenger) {
        this.parser = parser;
        this.messageService = messageService;
        this.messenger = messenger;
    }


    @Override
    public void testStudents() {

        String fileName = messageService.getQuestionsFileName();
        Map<String,String> questionsAndAnswers = parser.parseQuestionsFromFile(fileName);

        int numOfGoodAnswers = 0;
        Set<String> questions = questionsAndAnswers.keySet();
        System.out.println("Вывод имени фаила: " + fileName);


        messenger.askQuestion(messageService.getMessage("firstName.message", new Object[]{}));
        String firstName = messenger.answerQuestion();
        messenger.askQuestion(messageService.getMessage("secondName.message", new Object[]{}));
        String secondName = messenger.answerQuestion();

        for (String question : questions) {
            messenger.askQuestion(question);
            String answer = messenger.answerQuestion();
            if (questionsAndAnswers.get(question).toLowerCase().equals(answer.toLowerCase())) {
                numOfGoodAnswers++;
            }
        }

        System.out.println();
        System.out.println(messageService.getMessage("correct.answers", new Object[]{}) + numOfGoodAnswers + " / "+questions.size());
        System.out.println(messageService.getMessage("compliment.message", new Object[]{}) + firstName + " " + secondName + "!");
    }





    @Override
    public List<TestRes> getTestResults() {
        return testResults;
    }

//    private void defineLocale() {
//        if (language == null || language.isEmpty()) {
//            locale = LocaleContextHolder.getLocale();
//        } else if (language.equals("en")) {
//            locale = Locale.ENGLISH;
//        } else {
//            locale = new Locale("ru");
//        }
//    }
}
