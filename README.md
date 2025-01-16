# Payment Service

1. User -> OrderService - Order is created
2. User -> PaymentService
  - PaymentService needs to connect with OrderService to get order details - amount, etc.
  - Create Payment Link for that order
3. User -> Open Payment Link - Makes Payment
4. User gets redirected to the callback URL
5. Callback -> PaymentService - Check the status of the Payment OR
6. Payment Gateway -> PaymentService - Webhook URL

## APIs needed for this Design

- Payment Service
  - GetPaymentStatus
  - CreatePaymentLink
  - HandleWebhookEvent