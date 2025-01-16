package org.example.paymentservice.services;

import org.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.springframework.stereotype.Service;

public interface PaymentService {
    String createPaymentLink(String orderId);
}
