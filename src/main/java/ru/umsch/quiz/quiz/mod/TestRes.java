package ru.umsch.quiz.quiz.mod;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public  class TestRes {

    private String firstName;
    private String secondName;
    private Map<String, String> results = new HashMap<>();
    private int numOfGoodAnswers;
    private Date dateOfTesting;

    public TestRes() {
        dateOfTesting = new Date();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    public int getNumOfGoodAnswers() {
        return numOfGoodAnswers;
    }

    public void setNumOfGoodAnswers(int numOfGoodAnswers) {
        this.numOfGoodAnswers = numOfGoodAnswers;
    }

    public Date getDateOfTesting() {
        return dateOfTesting;
    }

    public void setDateOfTesting(Date dateOfTesting) {
        this.dateOfTesting = dateOfTesting;
    }
}
