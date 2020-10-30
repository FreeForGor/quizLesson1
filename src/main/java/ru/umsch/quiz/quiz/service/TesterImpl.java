package ru.umsch.quiz.quiz.service;

import ru.umsch.quiz.quiz.controller.Messenger;

import java.util.Map;
import java.util.Set;


public class TesterImpl implements Tester {

    private CsvParser parser;
    private Messenger messenger;

    public TesterImpl(CsvParser parser, Messenger messenger) {
        this.parser = parser;
        this.messenger = messenger;
    }

    @Override
    public void testStudents(String questionsFileName) {

        Map<String,String> questionsAndAnswers = parser.parseQuestionsFromFile(questionsFileName);
        int numOfGoodAnswers = 0;

        Set<String> questions = questionsAndAnswers.keySet();
        String firstName = messenger.askQuestion("Your first name: ");
        String secondName = messenger.askQuestion("Your second name: ");

        for (String question : questions) {
            String answer = messenger.askQuestion(question);
            if (questionsAndAnswers.get(question).toLowerCase().equals(answer.toLowerCase())) {
                numOfGoodAnswers++;
            }
        }

        System.out.println();
        System.out.println("Correct answers: " + numOfGoodAnswers + " / "+questions.size());
        System.out.println("Good job, " + firstName + " " + secondName + "!");
    }
}
