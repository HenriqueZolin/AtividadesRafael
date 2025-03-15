package com.example;

public class PixFactory extends PaymentFactory{

    @Override
    public PaymentStrategy criarPagamento() {
        return new PixPayment();
    }
}
