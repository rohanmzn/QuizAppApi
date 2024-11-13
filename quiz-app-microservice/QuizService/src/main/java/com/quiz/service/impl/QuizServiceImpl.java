package com.quiz.service.impl;

import com.quiz.dao.QuizDao;
import com.quiz.model.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        quizDao.save(quiz);
        return quiz;
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizDao.findAll();
        return quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

    }

    @Override
    public Quiz get(int id) {
        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
