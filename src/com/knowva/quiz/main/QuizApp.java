package com.knowva.quiz.main;

import com.knowva.quiz.control.QuizMasterManager;
import com.knowva.quiz.model.Course;
import com.knowva.quiz.model.Student;
import com.knowva.quiz.model.Topic;
import com.knowva.quiz.service.QuizSession;

import java.util.ArrayList;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        QuizMasterManager quizMasterManager = new QuizMasterManager();
        quizMasterManager.addCourse("Java Developer Track");
        quizMasterManager.addCourse("Advanced Mathematics");

        Course java = quizMasterManager.getCourse("Java Developer Track");
        Course math = quizMasterManager.getCourse("Advanced Mathematics");

        java.addTopic("Java Core & Poo");
        math.addTopic("Algebra & Calculus");

        Topic javaExam = java.getTopic("Java Core & Poo");
        Topic mathFinal = java.getTopic("Algebra & Calculus");

        // Basic Level (0 points)
        javaExam.addMultipleChoice("What does the Java compiler generate?", 0, "Bytecode", new String[]{"Source Code", "Bytecode", "Assembly"});
        javaExam.addMultipleChoice("Which component is responsible for running Java programs?", 0, "JVM", new String[]{"JDK", "JVM", "JRE"});
        javaExam.addMultipleChoice("Which of these is a primitive data type?", 0, "int", new String[]{"int", "Integer", "String"});
        javaExam.addMultipleChoice("What is the size of an int in bytes?", 0, "4", new String[]{"2", "4", "8"});
        javaExam.addMultipleChoice("Which keyword makes a variable constant?", 0, "Final", new String[]{"Static", "Final", "Abstract"});

        // Intermediate Level (5 points)
        javaExam.addMultipleChoice("Which keyword is used to inherit from a class?", 5, "Extends", new String[]{"Implements", "Extends", "Inherits"});
        javaExam.addMultipleChoice("What method is called when an object is instantiated?", 5, "Constructor", new String[]{"Method", "Constructor", "Function"});
        javaExam.addMultipleChoice("Which keyword refers to the current object instance?", 5, "This", new String[]{"Super", "This", "Self"});
        javaExam.addMultipleChoice("What is it called when two methods have the same name but different parameters?", 5, "Overloading", new String[]{"Overloading", "Overriding", "Hiding"});
        javaExam.addMultipleChoice("Which block is used to handle exceptions?", 5, "Try-Catch", new String[]{"If-Else", "Try-Catch", "While"});

        // Advanced Level (10 points)
        javaExam.addMultipleChoice("Which structure defines a contract for classes to implement?", 10, "Interface", new String[]{"Class", "Abstract Class", "Interface"});
        javaExam.addMultipleChoice("What mechanism automatically reclaims unused memory?", 10, "Garbage Collector", new String[]{"Memory Manager", "Garbage Collector", "Deleter"});
        javaExam.addMultipleChoice("Which keyword means a variable belongs to the class rather than the instance?", 10, "Static", new String[]{"Dynamic", "Static", "Volatile"});
        javaExam.addMultipleChoice("Which OOP concept allows an object to take many forms?", 10, "Polymorphism", new String[]{"Encapsulation", "Polymorphism", "Abstraction"});
        javaExam.addMultipleChoice("What is the smallest unit of execution within a process?", 10, "Thread", new String[]{"Thread", "Process", "Task"});


        // Basic Level (0 points)
        mathFinal.addMultipleChoice("What is the result of 2 + 2?", 0, "4", new String[]{"2", "4", "6"});
        mathFinal.addMultipleChoice("What is the square of 3?", 0, "9", new String[]{"3", "6", "9"});
        mathFinal.addMultipleChoice("Solve for x: 2x = 4", 0, "x=2", new String[]{"x=1", "x=2", "x=0"});
        mathFinal.addMultipleChoice("What is the side opposite the right angle called?", 0, "Hypotenuse", new String[]{"Leg", "Hypotenuse", "Angle"});
        mathFinal.addMultipleChoice("What is the sum of angles in a triangle?", 0, "180", new String[]{"90", "180", "360"});

        // Intermediate Level (5 points)
        mathFinal.addMultipleChoice("Which concept represents the rate of change?", 5, "Derivative", new String[]{"Integral", "Derivative", "Limit"});
        mathFinal.addMultipleChoice("What is the approximate value of PI?", 5, "3.1416", new String[]{"2.71", "3.1416", "1.61"});
        mathFinal.addMultipleChoice("What type of number is divisible only by 1 and itself?", 5, "Prime", new String[]{"Even", "Odd", "Prime"});
        mathFinal.addMultipleChoice("Which is the equation of a line?", 5, "y=mx+b", new String[]{"y=mx+b", "a^2+b^2=c^2", "E=mc^2"});
        mathFinal.addMultipleChoice("What is the inverse operation of exponentiation?", 5, "Logarithm", new String[]{"Power", "Root", "Logarithm"});

        // Advanced Level (10 points)
        mathFinal.addMultipleChoice("Which concept represents the area under a curve?", 10, "Integral", new String[]{"Integral", "Sum", "Product"});
        mathFinal.addMultipleChoice("What has both magnitude and direction?", 10, "Vector", new String[]{"Scalar", "Vector", "Matrix"});
        mathFinal.addMultipleChoice("What is a rectangular array of numbers called?", 10, "Matrix", new String[]{"List", "Matrix", "Set"});
        mathFinal.addMultipleChoice("What concept describes a quantity without bound?", 10, "Infinity", new String[]{"Zero", "One", "Infinity"});
        mathFinal.addMultipleChoice("What relates an input to exactly one output?", 10, "Function", new String[]{"Variable", "Function", "Constant"});

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
