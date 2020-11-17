package ru.umsch.quiz.quiz.service;




import ru.umsch.quiz.quiz.mod.TestRes;

import java.util.List;


public interface Tester {


    void testStudents();

    List<TestRes> getTestResults();
}
