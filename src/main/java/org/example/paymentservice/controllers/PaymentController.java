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

    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody String request) {
        // TODO: Save the status to the Db based on the event in the request
        System.out.println("Received webhook: " + request);
        return "Webhook received";
    }

    @PostMapping("/{orderId}/status")
    public String getPaymentStatus(String orderId) {
        // TODO: Fetch the status from Db
        // return paymentService.getPaymentStatus(orderId);
        return "Payment successful";
    }
}
