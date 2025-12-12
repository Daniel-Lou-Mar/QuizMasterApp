package com.knowva.quiz.service;

import java.util.ArrayList;

public class QuizSession {
    private ArrayList<Question> usedQuestions;
    public QuizSession(Student student, Topic topic) {
        this.student = student;
        this.topic = topic;
        this.usedQuestions = new ArrayList<>();
    }



}
