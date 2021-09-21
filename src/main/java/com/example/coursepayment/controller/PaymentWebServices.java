package com.example.coursepayment.controller;


import com.example.coursepayment.response.RespPaymentList;
import com.example.coursepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentWebServices {


    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/getPaymentList")// Ay Fuad
    public RespPaymentList getPaymentList() {
        return paymentService.getPaymentList();
    } // changes by c0pym4ster

}
