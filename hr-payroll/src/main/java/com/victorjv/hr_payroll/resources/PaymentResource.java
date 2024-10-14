package com.victorjv.hr_payroll.resources;

import com.victorjv.hr_payroll.entities.Payment;
import com.victorjv.hr_payroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    public PaymentService service;

    @CircuitBreaker(name= "myService", fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days){
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }


    public ResponseEntity<Payment> getPaymentAlternative( Long workerId, Integer days, Throwable t){
          Payment payment = new Payment("Brann", 400.0, days);
          return ResponseEntity.ok(payment);
    }
}
