package com.example;

public class CreditFactory extends PaymentFactory{

    @Override
    public PaymentStrategy criarPagamento() {
        return new CreditPayment();
    }
}
