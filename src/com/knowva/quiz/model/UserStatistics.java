package com.knowva.quiz.model;

public class UserStatistics {
    private int totalAnswered;
    private int correctAnswered;

    public int getCorrectAnswered() {
        return correctAnswered;
    }
    public void setCorrectAnswered(int correctAnswered) {
        this.correctAnswered = correctAnswered;
    }
    public int getTotalAnswered() {
        return totalAnswered;
    }
    public void setTotalAnswered(int totalAnswered) {
        this.totalAnswered = totalAnswered;
    }

    public getAccuracy(){
        if (totalAnswered == 0) return 0;
        return (correctAnswered * 100)/totalAnswered;
    }

    public update(int correct, int total){
       this.correctAnswered += correct;
       this.totalAnswered += total;
    }
}
