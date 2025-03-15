package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao, valor;
        PaymentProcessor formaDePagamento = new PaymentProcessor();
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
                pagamento = new PixPayment();
                break;
            case 2:
                pagamento = new CreditPayment();
                break;
            case 3:
                pagamento = new BoletoPayment();
                break;
            default:
                pagamento = null;
                break;
        }

        if(pagamento != null){
            formaDePagamento.setEstrategiaPagamento(pagamento);
            formaDePagamento.efetuarPagamento(valor);
        }else{
            System.out.println("Cancelando pagamento!");
        }

    }
}