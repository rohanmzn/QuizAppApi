package com.question.controller;

import com.question.modal.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getOne(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body(null); // Handle invalid ID
        }

        Question question = questionService.getOne(id);

        if (question == null) {
            return ResponseEntity.notFound().build(); // Handle not found case
        }

        return ResponseEntity.ok(question); // Return the found question
    }

    //get question of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Integer quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
