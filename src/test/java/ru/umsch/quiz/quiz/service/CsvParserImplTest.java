package ru.umsch.quiz.quiz.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CsvParserImplTest {



    @Test
    public void parserTest() {
        CsvParserImpl parser = new CsvParserImpl();

//        if (locale == null) {
//            defineLocale();
//        }
//        System.out.println(locale);
//
//        String fileName = locale == Locale.ENGLISH ? fileNameEn : fileNameRu;
//        System.out.println(fileName);

        String fileName = "questions-en.csv";
        System.out.println(fileName);
        Map<String,String> map = parser.parseQuestionsFromFile(fileName);
        String result = map.toString();
        String expected = "{" +
                "\"Who will rule Russia in 2024?\"=Putin, " +
                "\"what to throw to a drowning niger??\"=his family, " +
                "\"riddle by jacques fresco: 2+2+2/2-1?\"=4, " +
                "\"Who pisses in the porches?\"=Obama, " +
                "\"Where's the money..xxx..?\"=Lebowski" +
                "}";
        assertThat(result, is(expected));
    }

//    //@Test
//    public void defineLocale() {
//        if (language == null || language.isEmpty()) {
//            locale = LocaleContextHolder.getLocale();
//        } else if (language.equals("en")) {
//            locale = Locale.ENGLISH;
//        } else {
//            locale = new Locale("ru");
//        }
//    }
}