package com.knowva.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private static int NEXT_ID=0;
    private final int id;
    private String name;
    private List<Question> questionList;

    public Topic(String name) {
        this.id = NEXT_ID++;
        this.name = name;
        this.questionList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public void addMultipleChoice(String question,int difficulty, String correctAnswer , String[] options) {
        MultipleChoice multipleChoice = new MultipleChoice(question, difficulty, correctAnswer, options);
        addQuestion(multipleChoice);
    }
}
