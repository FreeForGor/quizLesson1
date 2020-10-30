package ru.umsch.quiz.quiz.service;

import org.junit.Test;
import ru.umsch.quiz.quiz.controller.Messenger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TesterImplTest {

    private final String FILE_NAME = "questions.csv";

    @Test
    public void testerTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        CsvParser parser = mock(CsvParser.class);
        Map<String,String> questionnaire = new LinkedHashMap<>();
        questionnaire.put("Who will rule Russia in 2024??", "Putin");
        questionnaire.put("what to throw to a drowning niger??", "his family");
        questionnaire.put("riddle by jacques fresco: 2+2+2/2-1?", "4");
        questionnaire.put("Who pisses in the porches?", "Obama");
        questionnaire.put("Where's the money..xxx..?", "Lebowski");
        questionnaire.put("Хуй?", "Пизда");
        questionnaire.put("А че оно нормально с русским языком работает?", "Да");
        when(parser.parseQuestionsFromFile(FILE_NAME)).thenReturn(questionnaire);

        Messenger messenger = mock(Messenger.class);
        when(messenger.askQuestion(anyString()))
                .thenReturn("Ivan")
                .thenReturn("Ivanov")
                .thenReturn("Putin")
                .thenReturn("his family")
                .thenReturn("4")
                .thenReturn("Obama")
                .thenReturn("Lebowski")
                .thenReturn("Пизда")
                .thenReturn("Да")
                .thenReturn("spring");


        TesterImpl tester = new TesterImpl(parser, messenger);
        tester.testStudents(FILE_NAME);

        String result = out.toString();
        String expected = "\nCorrect answers: 7 / 7\nGood job, Ivan Ivanov!\n";
        assertThat(result, is(expected));

        System.setOut(originalOut);
    }
}