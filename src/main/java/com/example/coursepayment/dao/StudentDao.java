package com.example.coursepayment.dao;



import com.example.coursepayment.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;

    void updateStudent(Student student) throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    void deleteStudent(Long studentId) throws Exception;

    Long studentCount() throws Exception;

}
