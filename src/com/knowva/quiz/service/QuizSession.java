package com.knowva.quiz.service;

import com.knowva.quiz.repository.MockQuestionRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizSession {
    private final MockQuestionRepository questionRepository;
    private final DifficultyEngine difficultyEngine;
    private Student student;
    private Topic topic;
    private int current_level;
    private int correct;
    private int total;
    private List<Question> usedQuestions;
    private List<Question> possibleQuestions;

    public QuizSession(Student student, Topic topic) {
        this.student = student;
        this.topic = topic;
        this.current_level = student.statistics.getAccuracy();
        this.correct = 0;
        this.total = 0;
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

    public void setCurrent_level(boolean result) {
        this.current_level = difficultyEngine.calculateNextDifficulty(this.current_level, result);
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
        return getPossibleQuestions().getFirst();
    }

    public void startPractice() {
        Scanner scanner = new Scanner(System.in);
        while (usedQuestions.size() <= possibleQuestions.size()) {
            Question question = selectQuestion();
            System.out.print(question.toString());
            int answer = scanner.nextInt();
            boolean result = question.checkAnswer(answer);
            if (result) {
                System.out.println("That is correct, congratulations!");
                this.correct++;
            } else {
                System.out.println("It is incorrect! :(");
            }
            setCurrent_level(result);
            this.total++;
            System.out.println("Next Question:");

        }
        System.out.println("There is not more questions.");
        System.out.println("Your final score was: " + this.correct + "/" + this.total);
        this.student.statistics.update(correct, total);
    }

}