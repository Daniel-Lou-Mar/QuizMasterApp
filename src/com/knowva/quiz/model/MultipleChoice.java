package com.knowva.quiz.model;

public class MultipleChoice extends Question{
    private String correctAnswer;
    private String[] options;


    public MultipleChoice(String question, int difficulty, String correctAnswer, String[] options) {
        super(question, difficulty);
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    @Override
    public boolean checkAnswer(int userAnswer) {
        int index = userAnswer - 1;
        if (index >= 0 && index < options.length) {
            return options[index].equalsIgnoreCase(correctAnswer);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n>>> Question: ").append((question));
        sb.append("\n(Difficulty: ").append(difficulty).append(")");
        for (int i = 0; i < options.length; i++) {
            sb.append("\n").append(i + 1).append(". ").append(options[i]);
        }
        return sb.toString() + "\n";
    }
}
