package com.knowva.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private List<Course> enrolledCourses;
    private UserStatistics statistics;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.enrolledCourses = new ArrayList<Course>();
        this.statistics = new UserStatistics();
    }


    public void enrollInCourses(Course course) {
         this.enrolledCourses.add(course);
    }

    public void printEnrolledCourses() {
        System.out.println("Enrollment Report for " + name + " " + surname + " ---" );
        for (int i = 0; i<enrolledCourses.size(); i++) {
            Course current = enrolledCourses.get(i);
            System.out.println("Class " + (i + 1) + ": " + current.getName());
        }
        System.out.println("Total classes enrolled: " + enrolledCourses.size());
    }

    public UserStatistics getStatistics(){
        return statistics;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

}
