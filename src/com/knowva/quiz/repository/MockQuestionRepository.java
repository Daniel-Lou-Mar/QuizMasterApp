package com.knowva.quiz.repository;

import java.util.ArrayList;
import java.util.List;

public class MockQuestionRepository implements QuestionRepository{
    @Override
    public getQuestionsByTopic(Topic topic) {
        return topic.getQuestionList();
    }
}