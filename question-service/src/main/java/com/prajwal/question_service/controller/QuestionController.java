package com.prajwal.question_service.controller;

import com.prajwal.question_service.model.Question;
import com.prajwal.question_service.model.QuestionResponse;
import com.prajwal.question_service.model.QuestionWrapper;
import com.prajwal.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    //read questions

    @GetMapping()
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getQuestions();
    }

    //create question

    @PostMapping()
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    //update question

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    //delete question

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

    //get questions by category

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    //---------------------------------//Endpoint for Quiz services//------------------------------

    //create questions for quiz
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQ) {
        return questionService.generateQuestionsForQuiz(category, numQ);
    }

    //retrieve questions for quiz
    @PostMapping("retrieve")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsForQuiz(ids);
    }

    //calculate score for quiz
    @PostMapping("score")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuestionResponse> response) {
        return questionService.getScoreForQuiz(response);
    }
}
