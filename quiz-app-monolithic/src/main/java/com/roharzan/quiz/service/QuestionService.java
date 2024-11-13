package com.roharzan.quiz.service;

import com.roharzan.quiz.model.Question;
import com.roharzan.quiz.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> addQuestion(Question newQuestion){
        questionDao.save(newQuestion);
        return new ResponseEntity<>("Successfully Added", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id){
        questionDao.deleteById(id);
        return new ResponseEntity<>("Question with id "+id+" deleted successfully",HttpStatus.OK);
    }

    public String updateQuestion(Integer id, Question updatedQuestion) {
        if (questionDao.existsById(id)) {
            updatedQuestion.setId(id);
            questionDao.save(updatedQuestion);
            return "Question with id " + id + " updated successfully";
        } else {
            return "Question with id " + id + " not found";
        }
    }
}
