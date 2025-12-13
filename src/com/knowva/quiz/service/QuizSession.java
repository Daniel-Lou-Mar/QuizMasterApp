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
    private int currentLevel;
    private int correct;
    private int total;
    private List<Question> usedQuestions;
    private List<Question> possibleQuestions;

    public QuizSession(Student student, Topic topic) {
        this.student = student;
        this.topic = topic;
        this.currentLevel = student.getStatistics().getAccuracy();
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

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(boolean result) {
        this.currentLevel = difficultyEngine.calculateNextDifficulty(getCurrentLevel(), result);
    }

    private boolean isUsed(Question question) {
        return usedQuestions.contains(question);
    }

    private Question selectQuestion() {
        int difficulty = difficultyEngine.associateDifficulty(getCurrentLevel());
        for (int i=0; i < getPossibleQuestions().size(); i++) {
            Question current = getPossibleQuestions().get(i);
            if (!isUsed(current)) {
                if (difficulty == current.getDifficulty()) {
                    setUsedQuestion(current);
                    return current;
                }
            }
        }

        // Search for any difficulty
        for (Question q : getPossibleQuestions()) {
            if (!isUsed(q)) {
                setUsedQuestion(q);
                return q;
            }
        }

        return null;
    }

    public void startPractice() {
        Scanner scanner = new Scanner(System.in);
        while (usedQuestions.size() < possibleQuestions.size()) {
            Question question = selectQuestion();
            System.out.print(question.toString());
            System.out.print("Enter your answer (number 1-3): ");

            int answer = -1;
            boolean isValidInput = false;

            while (!isValidInput) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                    System.out.print("Try again (number 1-3): ");
                    continue;
                }

                answer = scanner.nextInt();

                if (answer >= 1 && answer <= 3) {
                    isValidInput = true;
                } else {
                    System.out.println("Number out of range. Please enter a number between 1 and 3.");
                    System.out.print("Try again: ");
                }
            }

            boolean result = question.checkAnswer(answer);
            if (result) {
                System.out.println("That is correct, congratulations!");
                this.correct++;
            } else {
                System.out.println("It is incorrect! :(");
            }
            setCurrentLevel(result);
            this.total++;
            System.out.println("Next Question:");

        }
        System.out.println("There is not more questions.");
        System.out.println("Your final score was: " + this.correct + "/" + this.total);
        this.student.getStatistics().update(correct, total);
    }
}