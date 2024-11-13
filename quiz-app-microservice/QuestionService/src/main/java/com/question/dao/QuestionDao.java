package com.question.dao;

import com.question.modal.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByQuizId(Integer quizId);
}
