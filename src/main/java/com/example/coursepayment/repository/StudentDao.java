package com.example.coursepayment.repository;


import com.example.coursepayment.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentDao extends CrudRepository<Student,Long> {

    List<Student> findAllByActive(Integer active);



    Student findStudentByIdAndActive(Long id,Integer value);
}
