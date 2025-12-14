package com.knowva.quiz.main;

import com.knowva.quiz.model.Course;
import com.knowva.quiz.model.Student;
import com.knowva.quiz.model.Topic;
import com.knowva.quiz.service.QuizSession;

import java.util.ArrayList;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Developer Track");
        Course mathCourse = new Course("Advanced Mathematics");
        Topic mathFinal = new Topic("Algebra & Calculus");
        Topic javaExam = new Topic("Java Core & Poo");

        javaExam.addMultipleChoice(0, "Bytecode", new String[]{"Source Code", "Bytecode", "Assembly"});
        javaExam.addMultipleChoice(0, "JVM", new String[]{"JDK", "JVM", "JRE"});
        javaExam.addMultipleChoice(0, "int", new String[]{"int", "Integer", "String"});
        javaExam.addMultipleChoice(0, "4", new String[]{"2", "4", "8"});
        javaExam.addMultipleChoice(0, "Final", new String[]{"Static", "Final", "Abstract"});

        javaExam.addMultipleChoice(5, "Extends", new String[]{"Implements", "Extends", "Inherits"});
        javaExam.addMultipleChoice(5, "Constructor", new String[]{"Method", "Constructor", "Function"});
        javaExam.addMultipleChoice(5, "This", new String[]{"Super", "This", "Self"});
        javaExam.addMultipleChoice(5, "Overloading", new String[]{"Overloading", "Overriding", "Hiding"});
        javaExam.addMultipleChoice(5, "Try-Catch", new String[]{"If-Else", "Try-Catch", "While"});

        javaExam.addMultipleChoice(10, "Interface", new String[]{"Class", "Abstract Class", "Interface"});
        javaExam.addMultipleChoice(10, "Garbage Collector", new String[]{"Memory Manager", "Garbage Collector", "Deleter"});
        javaExam.addMultipleChoice(10, "Static", new String[]{"Dynamic", "Static", "Volatile"});
        javaExam.addMultipleChoice(10, "Polymorphism", new String[]{"Encapsulation", "Polymorphism", "Abstraction"});
        javaExam.addMultipleChoice(10, "Thread", new String[]{"Thread", "Process", "Task"});


        mathFinal.addMultipleChoice(0, "4", new String[]{"2", "4", "6"});
        mathFinal.addMultipleChoice(0, "9", new String[]{"3", "6", "9"});
        mathFinal.addMultipleChoice(0, "x=2", new String[]{"x=1", "x=2", "x=0"});
        mathFinal.addMultipleChoice(0, "Hypotenuse", new String[]{"Leg", "Hypotenuse", "Angle"});
        mathFinal.addMultipleChoice(0, "180", new String[]{"90", "180", "360"});

        mathFinal.addMultipleChoice(5, "Derivative", new String[]{"Integral", "Derivative", "Limit"});
        mathFinal.addMultipleChoice(5, "3.1416", new String[]{"2.71", "3.1416", "1.61"});
        mathFinal.addMultipleChoice(5, "Prime", new String[]{"Even", "Odd", "Prime"});
        mathFinal.addMultipleChoice(5, "y=mx+b", new String[]{"y=mx+b", "a^2+b^2=c^2", "E=mc^2"});
        mathFinal.addMultipleChoice(5, "Logarithm", new String[]{"Power", "Root", "Logarithm"});

        mathFinal.addMultipleChoice(10, "Integral", new String[]{"Integral", "Sum", "Product"});
        mathFinal.addMultipleChoice(10, "Vector", new String[]{"Scalar", "Vector", "Matrix"});
        mathFinal.addMultipleChoice(10, "Matrix", new String[]{"List", "Matrix", "Set"});
        mathFinal.addMultipleChoice(10, "Infinity", new String[]{"Zero", "One", "Infinity"});
        mathFinal.addMultipleChoice(10, "Function", new String[]{"Variable", "Function", "Constant"});

        javaCourse.getTopicList().add(javaExam);
        mathCourse.addTopic(mathFinal);

        List<Student> studentDirectory = new ArrayList<>();

        Student s1 = new Student("Maria", "Llanos");
        s1.enrollInCourses(javaCourse);
        s1.enrollInCourses(mathCourse);

        Student s2 = new Student("Sara", "Play");
        s2.enrollInCourses(mathCourse);

        Student s3 = new Student("Antonio", "Suarez");
        s3.enrollInCourses(javaCourse);
        s3.enrollInCourses(mathCourse);

        Student s4 = new Student("Juan", "Lopez");
        s4.enrollInCourses(mathCourse);

        studentDirectory.add(s1);
        studentDirectory.add(s2);
        studentDirectory.add(s3);
        studentDirectory.add(s4);


        System.out.println("\n--- SCHOOL MANAGEMENET SYSTEM ---");
        for (Student s : studentDirectory) {
            s.printEnrolledCourses();
            System.out.println("------------");
        }

        System.out.println("\nStarting Math Exam for" + s4.getName() + "...");
        QuizSession session = new QuizSession(s4, mathFinal);
        session.startPractice();


        System.out.println("\n>>> Second Session: Searching for a Java Student...");

        for (Student s : studentDirectory) {
            if (s.getName().equals("Antonio")) {
                System.out.println("Starting Java Exam for " + s.getName() + "...");
                QuizSession sessionJava = new QuizSession(s, javaExam);
                sessionJava.startPractice();
                break;
            }
        }
    }
}
