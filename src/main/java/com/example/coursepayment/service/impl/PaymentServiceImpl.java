package com.example.coursepayment.service.impl;


import com.example.coursepayment.enums.EnumAvailableStatus;
import com.example.coursepayment.model.Payment;
import com.example.coursepayment.repository.PaymentDao;
import com.example.coursepayment.response.*;
import com.example.coursepayment.service.PaymentService;
import com.example.coursepayment.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;



    @Override
    public RespPaymentList getPaymentList() {
        RespPaymentList response = new RespPaymentList();
        try {
            List<Payment> paymentList = paymentDao.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
            if(paymentList.isEmpty()){
                response.setStatus(new RespStatus(ExceptionConstants.PAYMENT_NOT_FOUND,"Payment not found"));
                return response;
            }
            List<RespPayment> respPaymentList = new ArrayList<>();
            for(Payment payment:paymentList){
                RespPayment respPayment = new RespPayment();
                respPayment.setPaymentId(payment.getId());
                RespStudent respStudent = new RespStudent();
                respStudent.setId(payment.getStudent().getId());
                respStudent.setName(payment.getStudent().getName());
                respStudent.setSurname(payment.getStudent().getSurname());
                respPayment.setStudent(respStudent);
                RespTeacher respTeacher = new RespTeacher();
                respTeacher.setId(payment.getTeacher().getId());
                respTeacher.setName(payment.getTeacher().getName());
                respTeacher.setSurname(payment.getTeacher().getSurname());
                respPayment.setTeacher(respTeacher);
                RespLesson respLesson = new RespLesson();
                respLesson.setLessonId(payment.getLesson().getId());
                respLesson.setLessonName(payment.getLesson().getName());
                respPayment.setLesson(respLesson);
                respPayment.setAmount(payment.getAmount());
                respPayment.setPayDate(payment.getPayDate());
                respPaymentList.add(respPayment);
            }
            response.setPaymentList(respPaymentList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }
}
