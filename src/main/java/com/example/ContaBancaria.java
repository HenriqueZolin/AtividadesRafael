package com.example;

public abstract class ContaBancaria {

    private int numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(int numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositor(double valor){
        this.saldo += valor>0?valor:0;
    }

    public abstract void sacar(double valor);

    public void exibirInformacoes(){
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
