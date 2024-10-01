package com.prajwal.quiz_service.controller;

import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import com.prajwal.quiz_service.model.Quiz;
import com.prajwal.quiz_service.model.QuizDTO;
import com.prajwal.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@CrossOrigin(origins = "http://localhost:5173")  // Allow only this origin
public class QuizController {

    @Autowired
    QuizService quizService;

    //generate new quiz
    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz
            (@RequestBody QuizDTO quizDTO) {
        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNumQ(),quizDTO.getTitle());
    }

    //fetch questions for quiz
    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuestionsFromId(id);
    }

    //submit quiz
    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz( @RequestBody List<QuestionResponse> response) {
        return quizService.getScore(response);
    }
}
