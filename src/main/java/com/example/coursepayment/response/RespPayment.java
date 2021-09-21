package com.example.coursepayment.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespPayment {

    private Long paymentId;
    private RespStudent student;
    private RespTeacher teacher;
    private RespLesson lesson;
    private Double amount;
    private Date payDate;

}
