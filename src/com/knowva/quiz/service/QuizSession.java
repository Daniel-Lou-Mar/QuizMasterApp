package com.knowva.quiz.service;

import com.knowva.quiz.repository.MockQuestionRepository;

import java.util.List;
import java.util.ArrayList;

public class QuizSession {
    private final MockQuestionRepository questionRepository;
    private final DifficultyEngine difficultyEngine;
    private Student student;
    private Topic topic;
    private int current_level;
    private List<Question> usedQuestions;
    private List<Question> possibleQuestions;

    public QuizSession(Student student, Topic topic) {
        this.student = student;
        this.topic = topic;
        this.current_level = student.statistics.getAccuracy();
        this.usedQuestions = new ArrayList<>();
        this.questionRepository = new MockQuestionRepository();
        this.difficultyEngine = new DifficultyEngine();
        this.possibleQuestions = this.questionRepository.getQuestionsByTopic(topic);
    }

    public List<Question> getUsedQuestions() {
        return usedQuestions;
    }

    public void setUsedQuestion(Question question) {
        this.usedQuestions.add(question);
    }

    public List<Question> getPossibleQuestions() {
        return possibleQuestions;
    }

    public int getCurrent_level() {
        return current_level;
    }

    public void setCurrent_level(int current_level) {
        this.current_level = current_level;
    }

    private boolean isUsed(Question question) {
        return usedQuestions.contains(question);
    }

    private Question selectQuestion() {
        int difficulty = difficultyEngine.associateDifficulty(this.current_level);
        for (int i; getPossibleQuestions().size(); i++) {
            Question current = getPossibleQuestions().get(i);
            if (!isUsed(current)) {
                if (difficulty == current.getDifficulty()) {
                    setUsedQuestion(current);
                    return current;
                }
            }
        }
        return null;
    }

    public void startPractice() {
        while (true) {
            System.out.println(selectQuestion().toString());
        }
    }

}