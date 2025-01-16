package org.example.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {
    @Override
    public String createPaymentLink(String orderId) {
        return "";
    }
}
