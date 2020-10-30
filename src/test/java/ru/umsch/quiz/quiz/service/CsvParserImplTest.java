package ru.umsch.quiz.quiz.service;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CsvParserImplTest {

    @Test
    public void parserTest() {
        CsvParserImpl parser = new CsvParserImpl();
        Map<String,String> map = parser.parseQuestionsFromFile("questions.csv");
        String result = map.toString();
        String expected = "{" +
                "\"Who will rule Russia in 2024?\"=Putin, " +
                "\"what to throw to a drowning niger??\"=his family, " +
                "\"riddle by jacques fresco: 2+2+2/2-1?\"=4, " +
                "\"Who pisses in the porches?\"=Obama, " +
                "\"Where's the money..xxx..?\"=Lebowski, " +
                "\"Хуй?\"=Пизда, " +
                "\"А че оно нормально с русским языком работает?\"=Да" +
                "}";
        assertThat(result, is(expected));
    }

}