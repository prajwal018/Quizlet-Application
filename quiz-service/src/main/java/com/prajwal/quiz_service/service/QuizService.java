package com.prajwal.quiz_service.service;

import com.prajwal.quiz_service.feign.QuestionClient;
import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import com.prajwal.quiz_service.model.Quiz;
import com.prajwal.quiz_service.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;


    public ResponseEntity<Quiz> createQuiz(String category, Integer numQ, String title) {
        try {
            Quiz quiz = new Quiz();
            List<Integer> questionIds = questionClient.generateQuestionForQuiz(category, numQ).getBody();
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
                return questionClient.getQuestionsFromId(quiz.getQuestionIds());
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
        return questionClient.getScore(response);
    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {
        try {
            return new ResponseEntity<>(quizRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
