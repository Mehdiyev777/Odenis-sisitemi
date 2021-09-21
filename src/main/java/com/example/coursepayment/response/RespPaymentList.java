package com.example.coursepayment.response;

import lombok.Data;

import java.util.List;

@Data
public class RespPaymentList {

    private List<RespPayment> paymentList;
    private RespStatus status;

}
