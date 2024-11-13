package com.roharzan.quiz.service;

import com.roharzan.quiz.dao.QuestionDao;
import com.roharzan.quiz.dao.QuizDao;
import com.roharzan.quiz.model.ResultWrapper;
import com.roharzan.quiz.model.Question;
import com.roharzan.quiz.model.QuestionWrapper;
import com.roharzan.quiz.model.Quiz;
import com.roharzan.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<Integer> createQuiz(String category, int numQ, String qTitle) {
        if (category == null || qTitle == null || numQ <= 0) {
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }

        List<Question> questions = questionDao.getRandomQuestionByCategory(category,numQ);

        Quiz quiz= new Quiz();
        quiz.setTitle(qTitle);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>(quiz.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        if (quiz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Or handle it as needed
        }

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3());
            questionsForUser.add(qw);
        }
         return  new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();//can be done as optional as in line 39

        List<Question> questions = quiz.getQuestions();

        int right=0;
        int i=0;
        for (Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
    return new ResponseEntity<>(right,HttpStatus.OK);
    }

    public ResponseEntity<List<ResultWrapper>> showAnswer(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<ResultWrapper> answerOfUser= new ArrayList<>();

        for (Question q : questionsFromDB){
            ResultWrapper rw = new ResultWrapper(q.getId(), q.getQuestionTitle(), q.getRightAnswer());
            answerOfUser.add(rw);
        }

        return  new ResponseEntity<>(answerOfUser,HttpStatus.OK);
    }
}
