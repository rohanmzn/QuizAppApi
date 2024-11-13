package com.roharzan.quiz.model;


import lombok.Data;

@Data
public class ResultWrapper {

    private Integer id;
    private String questionTitle;
    private String rightAnswer;

    public ResultWrapper(Integer id, String questionTitle, String rightAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.rightAnswer = rightAnswer;
    }
}
