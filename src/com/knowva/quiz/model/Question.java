package com.knowva.quiz.model;

public abstract class Question {
    protected int difficulty;

    public Question(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public abstract boolean checkAnswer(int userAnswer);

    @Override
    public abstract String toString();
}