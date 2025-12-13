package com.knowva.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private static int NEXT_ID=0;
    private final int id;
    private String name;
    private List<Topic> topicList;

    public Course(String name) {
        this.id = NEXT_ID++;
        this.name = name;
        this.topicList = new ArrayList<>();
    }

    public static int getNextId() {
        return NEXT_ID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void addTopic(Topic topic) {
        this.topicList.add(topic);
    }
}
