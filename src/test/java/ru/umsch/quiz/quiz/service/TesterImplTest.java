package ru.umsch.quiz.quiz.service;

import org.junit.Test;
import org.springframework.context.MessageSource;
import ru.umsch.quiz.quiz.controller.Messenger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TesterImplTest {

    private MessageSource messageSource;
    private final String FILE_NAME = "questions-en.csv";

    @Test
    public void testerTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        CsvParser parser = mock(CsvParser.class);
        Map<String,String> question = new LinkedHashMap<>();
        question.put("Who will rule Russia in 2024??", "Putin");
        question.put("what to throw to a drowning niger??", "his family");
        question.put("riddle by jacques fresco: 2+2+2/2-1?", "4");
        question.put("Who pisses in the porches?", "Obama");
        question.put("Where's the money..xxx..?", "Lebowski");
        when(parser.parseQuestionsFromFile(FILE_NAME)).thenReturn(question);

        MessageService messageService = mock(MessageService.class);
        when(messageService.getMessage(eq("firstName.message"), any())).thenReturn("Ivan");
        when(messageService.getMessage(eq("secondName.message"), any())).thenReturn("Ivanov");

        Messenger messenger = mock(Messenger.class);
        when(messenger.answerQuestion())
                .thenReturn("Ivan")
                .thenReturn("Ivanov")
                .thenReturn("Putin")
                .thenReturn("his family")
                .thenReturn("4")
                .thenReturn("Obama")
                .thenReturn("Lebowski");


        TesterImpl tester = new TesterImpl(parser, messageService, messenger);
        tester.testStudents();

        String result = out.toString();
        String expected = "\nCorrect answers: 5 / 5\nGood job, Ivan Ivanov!\n";
        assertThat(result, is(expected));

        System.setOut(originalOut);
    }
}