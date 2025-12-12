package com.knowva.quiz.repository;

public class MockQuestionRepository implements QuestionRepository{
    @Override
    public getQuestionsByTopic(Topic topic) {
        return topic.getQuestionList();
    }
}