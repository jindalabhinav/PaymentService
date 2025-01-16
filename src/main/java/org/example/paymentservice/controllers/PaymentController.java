package org.example.paymentservice.controllers;

import org.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.example.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto requestDto) {
        return paymentService.createPaymentLink(requestDto.getOrderId());
    }
}
