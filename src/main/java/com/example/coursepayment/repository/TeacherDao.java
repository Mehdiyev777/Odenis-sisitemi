package com.example.coursepayment.repository;


import com.example.coursepayment.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDao extends CrudRepository<Teacher,Long> {
}
