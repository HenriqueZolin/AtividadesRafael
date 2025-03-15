package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao, valor;
        PaymentFactory formaDePagamento;
        PaymentStrategy pagamento;

        System.out.println("Selecione a quantia: ");
        valor = ler.nextInt();

        System.out.println("Selecione a forma de pagamento: ");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de crédito");
        System.out.println("3 - Boleto");
        System.out.println("4 - Sair");
        opcao = ler.nextInt();

        switch(opcao){
            case 1:
                formaDePagamento = new PixFactory();
                break;
            case 2:
                formaDePagamento = new CreditFactory();
                break;
            case 3:
                formaDePagamento = new BoletoFactory();
                break;
            default:
                formaDePagamento = null;
                break;
        }

        if(formaDePagamento != null){
            pagamento = formaDePagamento.criarPagamento();
            pagamento.processPayment(valor);
        }else{
            System.out.println("Cancelando pagamento!");
        }

    }
}