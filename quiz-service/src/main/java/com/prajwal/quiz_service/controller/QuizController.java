package com.prajwal.quiz_service.controller;

import com.prajwal.quiz_service.model.QuestionResponse;
import com.prajwal.quiz_service.model.QuestionWrapper;
import com.prajwal.quiz_service.model.Quiz;
import com.prajwal.quiz_service.model.QuizDTO;
import com.prajwal.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    @Autowired
    QuizService quizService;

//    private final OllamaChatModel chatModel;

    //generate new quiz
    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz
            (@RequestBody QuizDTO quizDTO) {
        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNumQ(),quizDTO.getTitle());
    }

    //fetch all quiz
    @GetMapping()
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return quizService.getAllQuiz();
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

//    @GetMapping("/ai/generate")
//    public Flux<String> generateStream(@RequestParam(value = "message", defaultValue = "generate a 10 quiz name on java") String message) {
//        Prompt prompt = new Prompt(new UserMessage(message));
//        return chatModel.stream(prompt).map(response -> response.getResult().getOutput().getContent());
//    }
}
