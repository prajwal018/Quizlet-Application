package com.prajwal.quiz_service.feign;

import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("questions/quiz/generate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("questions/quiz/retrieve")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids);

    @PostMapping("questions/quiz/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuestionResponse> response);

}
