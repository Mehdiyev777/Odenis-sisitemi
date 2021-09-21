package com.example.coursepayment.repository;


import com.example.coursepayment.model.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentDao extends CrudRepository<Payment,Long> {

    List<Payment> findAllByActive(Integer active);

}
