package com.victorjv.hr_payroll.services;


import com.victorjv.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("Pedro Augusto", 200.0, days);
    }
}
