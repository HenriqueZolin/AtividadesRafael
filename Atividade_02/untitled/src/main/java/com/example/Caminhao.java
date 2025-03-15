package com.example;

public class Caminhao extends Veiculo{

    private double capacidadeCarga;
    private int tanque;
    private float consumo;
    private float pConsumo;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
        this.tanque = 300;
        this.pConsumo = (float) (capacidadeCarga>=25?(0.25):(capacidadeCarga/100));
        this.consumo = 6 - (6 * pConsumo);
    }

    @Override
    public double calcularAutononomia() {
        return (tanque * consumo);
    }

}
