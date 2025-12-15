package com.knowva.quiz.model;

public abstract class Question {
    protected int difficulty;
    protected String question;

    public Question(String question, int difficulty) {
        this.difficulty = difficulty;
        this.question = question;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public abstract boolean checkAnswer(int userAnswer);

    @Override
    public abstract String toString();
}