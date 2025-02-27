package com.example;

public class ContaSalario extends ContaCorrente{

    int quantSaques;

    public ContaSalario(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo, chequeEspecial);
        this.quantSaques = 0;
    }

    @Override
    public void sacar(double valor) {
        if(this.quantSaques == 0){
            super.sacar(valor);
        }else{
            super.sacar(valor + 5);
        }
    }
}
