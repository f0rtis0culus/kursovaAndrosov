package com.example.demo.controllers;

import com.example.demo.entities.Payment;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  private final PaymentRepository paymentRepository;

  public PaymentController(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  // Отримати всі платежі
  @GetMapping
  public List<Payment> getAllPayments() {
    return paymentRepository.findAll();
  }

  // Отримати платіж за ID
  @GetMapping("/{id}")
  public Optional<Payment> getPaymentById(@PathVariable Long id) {
    return paymentRepository.findById(id);
  }

  // Створити новий платіж
  @PostMapping
  public Payment createPayment(@RequestBody Payment payment) {
    return paymentRepository.save(payment);
  }
}
