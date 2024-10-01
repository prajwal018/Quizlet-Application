package com.prajwal.quiz_service.service;

import com.prajwal.quiz_service.feign.QuizInterface;
import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import com.prajwal.quiz_service.model.Quiz;
import com.prajwal.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<Quiz> createQuiz(String category, Integer numQ, String title) {
        try {
            Quiz quiz = new Quiz();
            List<Integer> questionIds = quizInterface.generateQuestionForQuiz(category, numQ).getBody();
                quiz.setTitle(title);
                quiz.setQuestionIds(questionIds);
                return new ResponseEntity<>(quizRepository.save(quiz), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Quiz(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(Integer id) {
        try {
            Optional<Quiz> quizFromDB = quizRepository.findById(id);
            if (quizFromDB.isPresent()) {
                Quiz quiz = quizFromDB.get();
                return quizInterface.getQuestionsFromId(quiz.getQuestionIds());
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Integer> getScore(List<QuestionResponse> response) {
        return quizInterface.getScore(response);
    }
}
