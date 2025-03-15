package com.example;

public abstract class Carro extends Veiculo{

    private String tipoCarro;
    private int tanque;
    private int consumo;

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, String tipoCarro) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.tipoCarro = tipoCarro;
        this.tanque = 50;
        this.consumo = 12;
    }

    @Override
    public double calcularAutononomia() {
        return (tanque * consumo);
    }

    public String exibirDetalhes(){
        return (super.exibirDetalhes() + " Tanque: " + this.tanque + "L Consumo: " + this.consumo + "km/l Autonomia: " + calcularAutononomia());
    }

}
