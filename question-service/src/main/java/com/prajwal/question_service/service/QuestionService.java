package com.prajwal.question_service.service;

import com.prajwal.question_service.model.Question;
import com.prajwal.question_service.model.QuestionResponse;
import com.prajwal.question_service.model.QuestionWrapper;
import com.prajwal.question_service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionRepository.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>("Question Deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Not Found with Id", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Question> updateQuestion(Integer id, Question newQuestionData) {
        try {
            Optional<Question> existingQuestion = questionRepository.findById(id);
            if (existingQuestion.isPresent()) {
                Question updatedQuestion = existingQuestion.get();
                updatedQuestion.setQuestionTitle(newQuestionData.getQuestionTitle());
                updatedQuestion.setOption1(newQuestionData.getOption1());
                updatedQuestion.setOption2(newQuestionData.getOption2());
                updatedQuestion.setOption3(newQuestionData.getOption3());
                updatedQuestion.setOption4(newQuestionData.getOption4());
                updatedQuestion.setRightAnswer(newQuestionData.getRightAnswer());
                updatedQuestion.setDifficultyLevel(newQuestionData.getDifficultyLevel());
                updatedQuestion.setCategory(newQuestionData.getCategory());
                return new ResponseEntity<>(questionRepository.save(updatedQuestion), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(String category, Integer numQ) {
        try {
            List<Integer> questionsNumbers = questionRepository.findRandomQuestionsByCategory(category, numQ);
            if (!questionsNumbers.isEmpty()) {
                return new ResponseEntity<>(questionsNumbers, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(List<Integer> ids) {
        try {
            List<QuestionWrapper> wrappers = new ArrayList<>();
            List<Question> questions = new ArrayList<>();
            for (Integer id : ids) {
                questions.add(questionRepository.findById(id).get());
            }
            for (Question q : questions) {
                QuestionWrapper wrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                wrappers.add(wrapper);
            }
            if (!wrappers.isEmpty()) {
                return new ResponseEntity<>(wrappers, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Integer> getScoreForQuiz(List<QuestionResponse> response) {
        try {
            int rightAnswer = 0;
            for (QuestionResponse qr : response) {
                Question question = questionRepository.findById(qr.getId()).get();
                if (qr.getResponse().equals(question.getRightAnswer()))
                    rightAnswer++;
            }
            return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
