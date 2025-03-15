package com.example;

public class BoletoPayment implements PaymentStrategy{

    private String numBoleto;

    public BoletoPayment() {
        this.numBoleto = "34195.17515 23456.787128 34123.456005 2 10017000002603";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Opção de boleto selecionada!");
        System.out.println("Número do boleto: " + this.numBoleto);
    }
}
