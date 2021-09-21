package com.example.coursepayment.response;

import lombok.Data;

@Data
public class RespLesson {

    private Long lessonId;
    private String lessonName;
    private Integer time;
    private Double price;

}
