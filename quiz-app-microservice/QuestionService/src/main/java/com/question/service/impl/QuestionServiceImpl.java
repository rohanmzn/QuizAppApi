package com.question.service.impl;

import com.question.dao.QuestionDao;
import com.question.modal.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Override
    public Question create(Question question) {
        return questionDao.save(question);
    }

    @Override
    public List<Question> get() {
        return questionDao.findAll();
    }

    @Override
    public Question getOne(int id) {
        return questionDao.findById(id).orElseThrow(()-> new RuntimeException("No question found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Integer quizId) {
        return questionDao.findByQuizId(quizId);
    }
}
