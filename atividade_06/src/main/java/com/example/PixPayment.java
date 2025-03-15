package com.example;

public class PixPayment implements PaymentStrategy{

    private String chavePix;

    public PixPayment() {
        this.chavePix = "henriquezolinmedeiros@gmail.com";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Opção de pix selecionada!");

        System.out.println("Chave pix, email: " +
                this.chavePix);
    }
}
