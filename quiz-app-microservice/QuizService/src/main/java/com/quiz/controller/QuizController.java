package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return  quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable int id) {
        return  quizService.get(id);
    }
}
