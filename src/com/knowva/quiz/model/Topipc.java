package com.knowva.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Topipc {
    private static int NEXT_ID=0;
    private final int id;
    private String name;
    private List<Question> questionList;

    public Topic(String name) {
        this.id = NEXT_ID++;
        this.name = name;
        this.questionList = new ArrayList<>();
    }

    public static int getNextId() {
        return NEXT_ID;
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

    public void addMultipleChoice(int difficulty, String correctAnswer , String[] options) {
        MultipleChoice multipleChoice = new MultipleChoice(difficulty, correctAnswer, options);
        addQuestion(multipleChoice);
    }
}
