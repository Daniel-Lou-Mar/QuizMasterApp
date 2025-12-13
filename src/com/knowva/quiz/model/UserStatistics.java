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

    public int getAccuracy(){
        if (totalAnswered == 0) return 0;
        int percentage =  (correctAnswered * 100)/totalAnswered;
        return percentage / 10 ;
    }

    public void update(int correct, int total){
       this.correctAnswered += correct;
       this.totalAnswered += total;
    }
}
