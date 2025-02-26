package com.example;

public class ContaInvestimentoAltoRisco extends ContaInvestimento{

    public ContaInvestimentoAltoRisco(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
        super.setTaxa(0.05);
    }

    @Override
    public void sacar(double valor) {
        if(valor > 10.000){
            super.sacar(valor);
            System.out.println("Saque realizado com sucesso");
        }else{
            System.out.println("Valor insuficiente para saque!");
        }

    }
}
