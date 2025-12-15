package com.knowva.quiz.control;

import com.knowva.quiz.model.Course;
import com.knowva.quiz.model.Student;
import com.knowva.quiz.model.Topic;
import com.knowva.quiz.service.QuizSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizMasterManager {
    private List<Course> courseList;
    private List<Student> studentList;
    private List<QuizSession> currentQuizSessionList;
    private List<QuizSession> pastQuizSessionList;

    public QuizMasterManager() {
        this.courseList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.currentQuizSessionList = new ArrayList<>();
        this.pastQuizSessionList = new ArrayList<>();
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(String name) {
        Course course = new Course(name);
        this.courseList.add(course);
    }

    public Course getCourse(String courseName) {
        for (Course c: getCourseList()) {
            if (Objects.equals(c.getName(), courseName)) {
                return c;
            }
        }
        return null;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(String name, String surname) {
        Student student = new Student(name, surname);
        studentList.add(student);
    }

    public Student getStudent(String name, String surname) {
        for (Student t: getStudentList()) {
            if (Objects.equals(t.getName(), name) &&  Objects.equals(t.getSurname(), surname)) {
                return t;
            }
        }
        return null;
    }

    public List<QuizSession> getCurrentQuizSessionList() {
        return currentQuizSessionList;
    }

    private void addCurrentQuizSession(QuizSession currentQuizSession) {
        currentQuizSessionList.add(currentQuizSession);
    }

    private void removeCurrentQuizSession(QuizSession currentQuizSession) {
        currentQuizSessionList.remove(currentQuizSession);
    }

    public List<QuizSession> getPastQuizSessionList() {
        return pastQuizSessionList;
    }

    private void addPastQuizSession(QuizSession pastQuizSession) {
        pastQuizSessionList.add(pastQuizSession);
    }


    public void startSession(Student student, Topic topic) {
        QuizSession quizSession = new QuizSession(student, topic);
        addCurrentQuizSession(quizSession);
        quizSession.startPractice();
        removeCurrentQuizSession(quizSession);
        addPastQuizSession(quizSession);
    }
}
