package com.prajwal.quiz_service.feign;

import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "question-url",
        url = "${application.config.question-url}")
public interface QuestionClient {

    @GetMapping("generate")
    ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("retrieve")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids);

    @PostMapping("score")
    ResponseEntity<Integer> getScore(@RequestBody List<QuestionResponse> response);

}
