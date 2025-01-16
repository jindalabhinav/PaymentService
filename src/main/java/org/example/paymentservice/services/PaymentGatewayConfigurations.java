package org.example.paymentservice.services;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentGatewayConfigurations {
    @Value("${razorpay.key_id}")
    private String rzpKeyId;

    @Value("${razorpay.key_secret}")
    private String rzpKeySecret;

    @Bean
    RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(rzpKeyId, rzpKeySecret);
    }
}
