package com.knowva.quiz.repository;

import com.knowva.quiz.model.Question;
import com.knowva.quiz.model.Topic;
import com.knowva.quiz.repository.QuestionRepository;

import java.util.List;

public class MockQuestionRepository implements QuestionRepository {
    @Override
    public List<Question> getQuestionsByTopic(Topic topic) {
        return topic.getQuestionList();
    }
}