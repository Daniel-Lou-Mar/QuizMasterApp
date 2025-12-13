package com.knowva.quiz.model;

public class MultipleChoice extends Question{
    private String correctAnswer;
    private String options;

    @Override
    public boolean checkAnswer() {
        // Lógica para comparar respuesta
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Opciones: " + options;
    }
}
}
