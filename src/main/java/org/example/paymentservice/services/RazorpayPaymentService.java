package org.example.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
public class RazorpayPaymentService implements PaymentService {
    private RazorpayClient razorpayClient;

    public RazorpayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createPaymentLink(String orderId) {
        // TODO: Get order details from the order service to create a payment link
        // Assuming we get the details we need to create a payment link from the order service

        JSONObject paymentLinkRequest = new JSONObject();
        /*
        Float or Double doesn't store the exact value but an approximate value.
        But this is not good for a financial application.
        Hence, we use the smallest unit of the currency (like paisa in INR) and store it as an integer.
         */
        paymentLinkRequest.put("amount",1000); // 1000 paisa = 10 INR
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("reference_id", UUID.randomUUID().toString()); // Needs to be unique every time
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 15*60*1000); // 15 minutes
        paymentLinkRequest.put("description","Payment for orderId:" + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name","+919000090000");
        customer.put("contact","Abhinav Jindal");
        customer.put("email","abhinav.jindal@example.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);

        JSONObject options = new JSONObject();
        JSONObject notes = new JSONObject();
        notes.put("Order Items","1-ipad, 1-iphone");
        notes.put("name","Abhinav Jindal");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url", "https://example.com/");
        paymentLinkRequest.put("callback_method", "get");
        try {
            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
