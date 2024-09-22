package com.victorjv.hr_payroll.services;

import com.victorjv.hr_payroll.entities.Payment;
import com.victorjv.hr_payroll.entities.Worker;
import com.victorjv.hr_payroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }
}
