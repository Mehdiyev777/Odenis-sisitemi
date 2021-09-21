package com.example.coursepayment.service;


import com.example.coursepayment.request.ReqStudent;
import com.example.coursepayment.response.RespStatus;
import com.example.coursepayment.response.RespStudent;
import com.example.coursepayment.response.RespStudentList;

public interface StudentService {

    RespStudentList getStudentList();

    RespStudent getStudentById(Long studentId);

    RespStatus addStudent(ReqStudent reqStudent);

    RespStatus updateStudent(ReqStudent reqStudent);

    RespStatus deleteStudent(Long studentId);
}
