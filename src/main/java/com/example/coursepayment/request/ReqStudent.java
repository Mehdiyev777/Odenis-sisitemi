package com.example.coursepayment.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqStudent {

    private Long studentId;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String phone;

}
