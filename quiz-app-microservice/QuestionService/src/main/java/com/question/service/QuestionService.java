package com.question.service;

import com.question.modal.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question create(Question question);
    List<Question> get();
    Question getOne(int id);

    List<Question> getQuestionsOfQuiz(Integer quizId);
}
