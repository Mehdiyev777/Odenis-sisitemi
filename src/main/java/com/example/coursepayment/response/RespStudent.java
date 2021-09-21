package com.example.coursepayment.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespStudent {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private Date dob;
    private String phone;
    private RespStatus status;


}
