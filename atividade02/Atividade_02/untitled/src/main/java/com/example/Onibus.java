package com.example;

import java.io.IOException;

public class Onibus extends Veiculo{

    public int quantidadeEixos;
    public int tanque;
    public int consumo;

    public Onibus(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int quantidadeEixos) throws Exception {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        if(quantidadeEixos>8 || quantidadeEixos<6){
            throw new Exception("Quantidade de eixos inválida");
        }else{
            this.quantidadeEixos = quantidadeEixos;
        }
        this.tanque = 200;
        this.consumo = 5;
    }

    @Override
    public double calcularAutononomia() {
        return (tanque * consumo);
    }
}
