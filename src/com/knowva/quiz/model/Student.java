package com.knowva.quiz.model;

public class Student {
    private String name;
    private String surname;
    private Course course;
    private UserStatistics statistics;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.statistics = new UserStatistics();
    }


    public Course getCourse() {
        return course;
    }

    public getStadistics(){
    }
}
