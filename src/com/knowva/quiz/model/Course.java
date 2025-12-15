package com.knowva.quiz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void addTopic(String name) {
        Topic topic = new Topic(name);
        this.topicList.add(topic);
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public Topic getTopic(String topicName) {
        for (Topic t: getTopicList()) {
            if (Objects.equals(t.getName(), topicName)) {
                return t;
            }
        }
        return null;
    }

}
