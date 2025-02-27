package com.example;

public class ContaPoupanca extends ContaBancaria{


    public ContaPoupanca(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if(valor < this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Valor sacado com sucesso");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
}
