package com.knowva.quiz.repository;

import java.util.List;

public interface QuestionRepository {
    List<Question> getQuestionsByTopic(Topic topic);
}