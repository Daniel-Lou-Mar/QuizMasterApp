package com.knowva.quiz.repository;

import com.knowva.quiz.repository.QuestionRepository;

public class MockQuestionRepository implements QuestionRepository {
    @Override
    public getQuestionsByTopic(Topic topic) {
        return topic.getQuestionList();
    }
}