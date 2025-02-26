package com.example;

public class ContaCorrente extends ContaBancaria{

    private double chequeEspecial;

    public ContaCorrente(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if(valor > this.getSaldo() + this.chequeEspecial){
            System.out.println("Quantidade de saldo + limite de cheque especial insuficiente");
        }else{
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado");
        }
    }
}
