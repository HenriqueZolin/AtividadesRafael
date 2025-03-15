package com.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando instâncias dos veículos
            CarroEletrico tesla = new CarroEletrico("Tesla", "Model S", 2022, 5, "Elétrico", "Sedan", 100);
            Caminhao volvo = new Caminhao("Volvo", "FH16", 2021, 2, "Diesel", 30);
            CaminhaoRefrigerado scania = new CaminhaoRefrigerado("Scania", "R500", 2020, 2, "Diesel", 28, -18);
            Onibus mercedes = new Onibus("Mercedes", "O-500RSD", 2019, 50, "Diesel", 6);

            // Testando os métodos
            System.out.println("=== Teste dos Veículos ===");
            System.out.println(tesla.exibirDetalhes());
            System.out.println("Autonomia: " + tesla.calcularAutononomia() + " km");

            System.out.println(volvo.exibirDetalhes());
            System.out.println("Autonomia: " + volvo.calcularAutononomia() + " km");

            System.out.println(scania.exibirDetalhes());
            System.out.println("Autonomia: " + scania.calcularAutononomia() + " km");

            System.out.println(mercedes.exibirDetalhes());
            System.out.println("Autonomia: " + mercedes.calcularAutononomia() + " km");
        } catch (Exception e) {
            System.out.println("Erro ao criar veículo: " + e.getMessage());
        }
    }


}