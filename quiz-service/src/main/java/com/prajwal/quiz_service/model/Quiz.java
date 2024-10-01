package com.prajwal.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
//    private Integer numQ;
//    private String category;
    @ElementCollection
    private List<Integer> questionIds;
}
