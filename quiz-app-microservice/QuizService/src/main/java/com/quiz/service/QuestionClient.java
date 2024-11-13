package com.quiz.service;

import com.quiz.model.Question;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082", value = "Question-Client")
//use below for eureka server
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Integer quizId);
}
