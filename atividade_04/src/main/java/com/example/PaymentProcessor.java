package com.example;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public void setEstrategiaPagamento(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void efetuarPagamento(double valor){
        paymentStrategy.processPayment(valor);
    }
}
