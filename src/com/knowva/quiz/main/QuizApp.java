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


        javaExam.addMultipleChoice(0, "What is the output format of the Java compiler?", "Bytecode", new String[]{"Source Code", "Bytecode", "Assembly"});
        javaExam.addMultipleChoice(0, "Which component runs the compiled Java code?", "JVM", new String[]{"JDK", "JVM", "JRE"});
        javaExam.addMultipleChoice(0, "Which is a primitive data type for integers?", "int", new String[]{"int", "Integer", "String"});
        javaExam.addMultipleChoice(0, "How many bytes does an 'int' type occupy in Java?", "4", new String[]{"2", "4", "8"});
        javaExam.addMultipleChoice(0, "Which keyword prevents a variable from being modified?", "Final", new String[]{"Static", "Final", "Abstract"});


        javaExam.addMultipleChoice(5, "Which keyword is used to inherit a class?", "Extends", new String[]{"Implements", "Extends", "Inherits"});
        javaExam.addMultipleChoice(5, "What is the special method used to initialize objects?", "Constructor", new String[]{"Method", "Constructor", "Function"});
        javaExam.addMultipleChoice(5, "Which keyword refers to the current instance of the class?", "This", new String[]{"Super", "This", "Self"});
        javaExam.addMultipleChoice(5, "Having two methods with the same name but different parameters is:", "Overloading", new String[]{"Overloading", "Overriding", "Hiding"});
        javaExam.addMultipleChoice(5, "Which block is used to handle runtime errors?", "Try-Catch", new String[]{"If-Else", "Try-Catch", "While"});


        javaExam.addMultipleChoice(10, "What provides total abstraction and defines contracts?", "Interface", new String[]{"Class", "Abstract Class", "Interface"});
        javaExam.addMultipleChoice(10, "What automatically manages memory by deleting unused objects?", "Garbage Collector", new String[]{"Memory Manager", "Garbage Collector", "Deleter"});
        javaExam.addMultipleChoice(10, "Which keyword allows a member to belong to the class rather than an instance?", "Static", new String[]{"Dynamic", "Static", "Volatile"});
        javaExam.addMultipleChoice(10, "The ability of an object to take many forms is called:", "Polymorphism", new String[]{"Encapsulation", "Polymorphism", "Abstraction"});
        javaExam.addMultipleChoice(10, "What represents the smallest unit of execution within a process?", "Thread", new String[]{"Thread", "Process", "Task"});

        javaExam.addMultipleChoice(0, "What is the output format of the Java compiler?", "Bytecode", new String[]{"Source Code", "Bytecode", "Assembly"});
        javaExam.addMultipleChoice(0, "Which component runs the compiled Java code?", "JVM", new String[]{"JDK", "JVM", "JRE"});
        javaExam.addMultipleChoice(0, "Which is a primitive data type for integers?", "int", new String[]{"int", "Integer", "String"});
        javaExam.addMultipleChoice(0, "How many bytes does an 'int' type occupy in Java?", "4", new String[]{"2", "4", "8"});
        javaExam.addMultipleChoice(0, "Which keyword prevents a variable from being modified?", "Final", new String[]{"Static", "Final", "Abstract"});

        javaExam.addMultipleChoice(5, "Which keyword is used to inherit a class?", "Extends", new String[]{"Implements", "Extends", "Inherits"});
        javaExam.addMultipleChoice(5, "What is the special method used to initialize objects?", "Constructor", new String[]{"Method", "Constructor", "Function"});
        javaExam.addMultipleChoice(5, "Which keyword refers to the current instance of the class?", "This", new String[]{"Super", "This", "Self"});
        javaExam.addMultipleChoice(5, "Having two methods with the same name but different parameters is:", "Overloading", new String[]{"Overloading", "Overriding", "Hiding"});
        javaExam.addMultipleChoice(5, "Which block is used to handle runtime errors?", "Try-Catch", new String[]{"If-Else", "Try-Catch", "While"});

        javaExam.addMultipleChoice(10, "What provides total abstraction and defines contracts?", "Interface", new String[]{"Class", "Abstract Class", "Interface"});
        javaExam.addMultipleChoice(10, "What automatically manages memory by deleting unused objects?", "Garbage Collector", new String[]{"Memory Manager", "Garbage Collector", "Deleter"});
        javaExam.addMultipleChoice(10, "Which keyword allows a member to belong to the class rather than an instance?", "Static", new String[]{"Dynamic", "Static", "Volatile"});
        javaExam.addMultipleChoice(10, "The ability of an object to take many forms is called:", "Polymorphism", new String[]{"Encapsulation", "Polymorphism", "Abstraction"});
        javaExam.addMultipleChoice(10, "What represents the smallest unit of execution within a process?", "Thread", new String[]{"Thread", "Process", "Task"});


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

        //First Student starts a maths exam

        System.out.println("\nStarting Math Exam for" + s4.getName() + "...");
        QuizSession session = new QuizSession(s4, mathFinal);
        session.startPractice();


        //Second student start a java exam
        System.out.println("\n>>> Second Session: Searching for a Java Student...");

        for (Student s : studentDirectory) {
            if (s.getName().equals("Antonio")) {

                if (s.getEnrolledCourses().contains(javaCourse)) {
                    QuizSession javaSession = new QuizSession(s, javaExam);
                    javaSession.startPractice();
                } else {
                    System.out.println("Access Denied: Student is not enrolled in Java.");
                }
                break;
            }
        }

        System.out.println("\n--- FINAL ACADEMY REPORT ---");
        for (Student s : studentDirectory) {
            System.out.println("Student " + s.getName() + "| Final Score: " + s.getStatistics());
    }


    }
}
