package com.roharzan.quiz.controller;

import com.roharzan.quiz.model.ResultWrapper;
import com.roharzan.quiz.model.Question;
import com.roharzan.quiz.model.QuestionWrapper;
import com.roharzan.quiz.model.Response;
import com.roharzan.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<Integer>
        createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String qTitle){
//        return new ResponseEntity<>("HI", HttpStatus.OK);
        return quizService.createQuiz(category,numQ,qTitle);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>
        submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

    @GetMapping("answer/{id}")
    public ResponseEntity<List<ResultWrapper>> showAnswer(@PathVariable Integer id){
        return quizService.showAnswer(id);
    }
}
