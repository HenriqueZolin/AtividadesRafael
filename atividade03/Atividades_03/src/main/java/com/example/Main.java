package com.example;

public class Main {
    public static void main(String[] args) {

        // Teste Conta Corrente
        ContaCorrente contaCorrente = new ContaCorrente(12345, "João Silva", 1000, 500);
        contaCorrente.exibirInformacoes();
        contaCorrente.depositor(200);
        contaCorrente.sacar(1300);
        contaCorrente.sacar(1800);
        contaCorrente.exibirInformacoes();

        System.out.println("------------------------");

        // Teste Conta Poupança
        ContaPoupanca contaPoupanca = new ContaPoupanca(54321, "Maria Oliveira", 1500);
        contaPoupanca.exibirInformacoes();
        contaPoupanca.sacar(200);
        contaPoupanca.sacar(2000);
        contaPoupanca.exibirInformacoes();

        System.out.println("------------------------");

        // Teste Conta Investimento
        ContaInvestimento contaInvestimento = new ContaInvestimento(67890, "Carlos Souza", 5000);
        contaInvestimento.exibirInformacoes();
        contaInvestimento.sacar(1000);
        contaInvestimento.sacar(5000);
        contaInvestimento.exibirInformacoes();

        System.out.println("------------------------");

        // Teste Conta Salário
        ContaSalario contaSalario = new ContaSalario(13579, "Ana Lima", 2000, 300);
        contaSalario.exibirInformacoes();
        contaSalario.sacar(500);
        contaSalario.sacar(300);
        contaSalario.exibirInformacoes();

        System.out.println("------------------------");

        // Teste Conta Investimento Alto Risco
        ContaInvestimentoAltoRisco contaAltoRisco = new ContaInvestimentoAltoRisco(98765, "Lucas Martins", 20000);
        contaAltoRisco.exibirInformacoes();
        contaAltoRisco.sacar(5000);
        contaAltoRisco.sacar(15000);
        contaAltoRisco.exibirInformacoes();

    }
}
