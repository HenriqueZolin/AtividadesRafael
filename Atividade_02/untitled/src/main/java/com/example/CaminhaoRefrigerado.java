package com.example;

public class CaminhaoRefrigerado extends Caminhao{

    private float temperaturaMinima;

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga, float temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularAutononomia() {
        return (super.calcularAutononomia() * 0.9);
    }
}
