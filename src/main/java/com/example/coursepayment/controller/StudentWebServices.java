package com.example.coursepayment.controller;


import com.example.coursepayment.request.ReqStudent;
import com.example.coursepayment.response.RespStatus;
import com.example.coursepayment.response.RespStudent;
import com.example.coursepayment.response.RespStudentList;
import com.example.coursepayment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentWebServices {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudentList", method = {RequestMethod.GET,RequestMethod.POST})
    public RespStudentList getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping(value = "/getStudentById/{studentId}")
    public RespStudent getStudentById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/addStudent")
    public RespStatus addStudent(@RequestBody ReqStudent reqStudent) {
        return studentService.addStudent(reqStudent);
    }

    @PutMapping(value = "/updateStudent")
    public RespStatus updateStudent(@RequestBody ReqStudent reqStudent) {
        return studentService.updateStudent(reqStudent);
    }

    @PutMapping(value = "/deleteStudent")
    public RespStatus deleteStudent(@RequestParam("studentId") Long studentId) {
        return studentService.deleteStudent(studentId);
    }

}
