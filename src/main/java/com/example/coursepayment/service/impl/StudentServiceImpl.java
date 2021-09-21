package com.example.coursepayment.service.impl;


import com.example.coursepayment.dao.StudentDao;
import com.example.coursepayment.enums.EnumAvailableStatus;
import com.example.coursepayment.model.Student;
import com.example.coursepayment.request.ReqStudent;
import com.example.coursepayment.response.RespStatus;
import com.example.coursepayment.response.RespStudent;
import com.example.coursepayment.response.RespStudentList;
import com.example.coursepayment.service.StudentService;
import com.example.coursepayment.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private com.example.coursepayment.repository.StudentDao studentDao1;

    @Override
    public RespStudentList getStudentList() {
        RespStudentList response = new RespStudentList();
        List<RespStudent> respStudentList = new ArrayList<>();
        try {
            //   List<Student> studentList = studentDao.getStudentList();
            List<Student> studentList = studentDao1.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
            if (studentList.isEmpty()) {
                response.setStatus(new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found"));
                return response;
            }
            for (Student student : studentList) {
                RespStudent respStudent = new RespStudent();
                respStudent.setId(student.getId());
                respStudent.setName(student.getName());
                respStudent.setSurname(student.getSurname());
                respStudent.setAddress(student.getAddress());
                respStudent.setDob(student.getDob());
                respStudent.setPhone(student.getPhone());
                respStudentList.add(respStudent);
            }
            response.setStudentList(respStudentList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }

    @Override
    public RespStudent getStudentById(Long studentId) {
        RespStudent response = new RespStudent();
        try {
            if (studentId == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data"));
                return response;
            }
            //    Student student = studentDao.getStudentById(studentId);
            Student student = studentDao1.findStudentByIdAndActive(studentId,EnumAvailableStatus.ACTIVE.getValue());
            if (student == null) {
                response.setStatus(new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found"));
                return response;
            }
            response.setId(student.getId());
            response.setName(student.getName());
            response.setSurname(student.getSurname());
            response.setAddress(student.getAddress());
            response.setDob(student.getDob());
            response.setPhone(student.getPhone());
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }

    @Override
    public RespStatus addStudent(ReqStudent reqStudent) {
        RespStatus response = null;
        String name = reqStudent.getName();
        String surname = reqStudent.getSurname();
        Date dob = reqStudent.getDob();
        String address = reqStudent.getAddress();
        String phone = reqStudent.getPhone();
        try {
            if (name == null || surname == null) {
                return new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setDob(dob);
            student.setAddress(address);
            student.setPhone(phone);
            // studentDao.addStudent(student);
            studentDao1.save(student);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
        }
        return response;
    }

    @Override
    public RespStatus updateStudent(ReqStudent reqStudent) {
        RespStatus response = null;
        Long studentId = reqStudent.getStudentId();
        String name = reqStudent.getName();
        String surname = reqStudent.getSurname();
        Date dob = reqStudent.getDob();
        String address = reqStudent.getAddress();
        String phone = reqStudent.getPhone();
        try {
            if (studentId == null || name == null || surname == null) {
                return new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = studentDao1.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.getValue());
            if (student == null) {
                response = new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found");
                return response;
            }
            student.setName(name);
            student.setSurname(surname);
            student.setDob(dob);
            student.setAddress(address);
            student.setPhone(phone);
            //   studentDao.updateStudent(student);
            studentDao1.save(student);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
        }
        return response;
    }

    @Override
    public RespStatus deleteStudent(Long studentId) {

        RespStatus response = null;
        try {
            if (studentId == null) {
                return new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = studentDao1.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.getValue());
            if (student == null) {
                response = new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found");
                return response;
            }
            student.setActive(EnumAvailableStatus.DEACTIVE.getValue());
            studentDao1.save(student);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
        }
        return response;

    }
}