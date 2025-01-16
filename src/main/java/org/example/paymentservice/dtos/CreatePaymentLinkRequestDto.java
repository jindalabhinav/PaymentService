package org.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

public class CreatePaymentLinkRequestDto {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
