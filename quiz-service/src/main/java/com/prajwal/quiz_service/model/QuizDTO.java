package com.prajwal.quiz_service.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class QuizDTO {
    private String category;
    private Integer numQ;
    private String title;
}
