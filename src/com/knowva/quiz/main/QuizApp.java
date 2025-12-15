package com.knowva.quiz.main;

import com.knowva.quiz.control.QuizMasterManager;
import com.knowva.quiz.model.Course;
import com.knowva.quiz.model.Student;
import com.knowva.quiz.model.Topic;
import com.knowva.quiz.service.QuizSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Topic mathFinal = math.getTopic("Algebra & Calculus");

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

        quizMasterManager.addStudent("Juan", "Pérez");
        Student student = quizMasterManager.getStudent("Juan", "Pérez");

        System.out.println(student.getEnrolledCourses());

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------Welcome to the KnowaQuizMaster------------------");
        System.out.println("------------------------------------------------------------------");

        while(true) {
            System.out.println("\n" + student.getName() + ", select a course or view your statistics:");
            System.out.println("1. Enroll more courses.");
            System.out.println("2. View my statistics.");
            if (!student.getEnrolledCourses().isEmpty()) {
                for (int i=0; i < student.getEnrolledCourses().size(); i++) {
                    System.out.println((i+3)+ ". " + student.getEnrolledCourses().get(i).getName());
                }
            }

            int sum = student.getEnrolledCourses().isEmpty() ? 3 : student.getEnrolledCourses().size()+3;

            System.out.println(sum + ". Exit.");

            int answer = sum == 3 ? checkInput(scanner, 3) : checkInput(scanner,student.getEnrolledCourses().size()+3);


            if (answer == 1) {
                System.out.println("\nChoose one course to enroll:");
                List<Course> notEnrolled = notEnrrollList(student, quizMasterManager);

                if (notEnrolled.isEmpty()) {
                    System.out.println("You can not enroll to more courses.");
                } else {
                    for (int i=0; i < notEnrolled.size(); i++) {
                        System.out.println(i+1 + ". " + notEnrolled.get(i).getName());
                    }

                    answer = checkInput(scanner,notEnrolled.size()+1);
                    student.enrollInCourses(notEnrolled.get(answer-1));
                }

            } else if (answer == 2) {
                System.out.println("\n--------My statistics--------");
                System.out.println("Total answered: " + student.getStatistics().getTotalAnswered());
                System.out.println("Correct answered: " + student.getStatistics().getCorrectAnswered());
                System.out.println("Your actual level 1/10: " + student.getStatistics().getAccuracy());
                System.out.println("-----------------------------");


            } else if (answer == 3 && sum == 3 || sum != 3 && answer == student.getEnrolledCourses().size()+3) {
                break;
            } else {
                Course currentCourse = student.getEnrolledCourses().get(answer-3);
                System.out.println("Choose one option:");
                for (int i=0; i < currentCourse.getTopicList().size(); i++) {
                    System.out.println(i+1 + ". " + currentCourse.getTopicList().get(i).getName());
                }

                System.out.println(currentCourse.getTopicList().size()+1 + ". Go back");
                System.out.println(currentCourse.getTopicList().size()+2 + ". Exit");

                answer = checkInput(scanner,currentCourse.getTopicList().size()+3);

                if (answer == currentCourse.getTopicList().size()+1) {
                } else if (answer == currentCourse.getTopicList().size()+2) {
                    break;
                } else {
                    Topic currentTopic = currentCourse.getTopicList().get(answer-1);
                    System.out.println("Choose one option:");
                    System.out.println("1. See " + currentTopic.getName() + " contents");
                    System.out.println("2. Do the topic quiz");
                    System.out.println("3. Exit.");

                    answer = checkInput(scanner, 2);
                    if (answer == 3) {
                        break;
                    } else if (answer == 1) {
                        while (answer == 1) {
                            System.out.println("\nWork in progress.\n");
                            System.out.println("Choose one option:");
                            System.out.println("1. See topic contents");
                            System.out.println("2. Do the topic quiz");
                            System.out.println("3. Exit.");
                            answer = checkInput(scanner, 2);
                            if (answer == 3) {
                                break;
                            }
                        }
                    }

                    quizMasterManager.startQuizSession(student, currentTopic);
                }
            }

        }
        System.out.println("\n\n Thank you for using Knowa " + student.getName());

    }

    public static List<Course> notEnrrollList(Student student, QuizMasterManager quizMasterManager) {
        List<Course> courses = new ArrayList<>();
        for (Course c: quizMasterManager.getCourseList()) {
            if (!student.getEnrolledCourses().contains(c)) {
                courses.add(c);
            }
        }
        return courses;
    }

    public static int checkInput(Scanner scanner, int max) {
        int answer;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                System.out.print("Try again (number 1-" + max + "): ");
                continue;
            }

            answer = scanner.nextInt();

            if (answer >= 1 && answer <= max) {
                return answer;
            } else {
                System.out.println("Number out of range. Please enter a number between 1 and " + max + ".");
                System.out.print("Try again: ");
            }
        }
    }

}
