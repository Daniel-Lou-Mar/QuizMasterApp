package com.knowva.quiz.repository;

import com.knowva.quiz.model.Question;
import com.knowva.quiz.model.Topic;

import java.util.List;

public interface QuestionRepository {
    List<Question> getQuestionsByTopic(Topic topic);
}