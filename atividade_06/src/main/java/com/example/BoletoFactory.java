package com.example;

public class BoletoFactory extends PaymentFactory{

    @Override
    public PaymentStrategy criarPagamento() {
        return new BoletoPayment();
    }
}
