package com.example;

public class ContaInvestimento extends ContaBancaria{

    private double taxa;

    public ContaInvestimento(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
        this.taxa = 0.02;
    }

    @Override
    public void sacar(double valor) {
        if((valor + (valor * taxa)) < this.getSaldo()){
            this.setSaldo(this.getSaldo() - (valor + (valor * taxa)));
        }else{
            System.out.println("Saldo + juros insuficiente");
        }
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
}
