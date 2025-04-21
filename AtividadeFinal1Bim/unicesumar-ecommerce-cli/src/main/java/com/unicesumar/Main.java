package com.unicesumar;

import com.unicesumar.PaymentManager;
import com.unicesumar.PaymentMethodFactory;
import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.entities.Venda;
import com.unicesumar.paymentMethods.PaymentType;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;
import com.unicesumar.repository.VendaRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;
        VendaRepository listaDeVendas = null;
        PaymentManager formaPagamento = new PaymentManager();

        Connection conn = null;
        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
                listaDeVendas = new VendaRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Fazer venda");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    System.out.println("Cadastrar Produto");
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    listaDeProdutos.save(new Product(nomeProduto, preco));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Listar Produtos");
                    List<Product> products = listaDeProdutos.findAll();
                    for(Product produto : products){
                        System.out.println(produto.getUuid() + " - " + produto.toString());
                    }
                    break;

                case 3:
                    System.out.println("Cadastrar Usuário");
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = scanner.nextLine();
                    listaDeUsuarios.save(new User(nome, email, senha));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("Listar Usuários");
                    List<User> users = listaDeUsuarios.findAll();
                    users.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Realizando venda");
                    System.out.print("Digite o Email do usuário: ");
                    String emailUser = scanner.nextLine();
                    Optional<User> usuarioEncontrado = listaDeUsuarios.findByEmail(emailUser);
                    if (!usuarioEncontrado.isPresent()) {
                        System.out.println("Usuário não encontrado, saindo...");
                        break;
                    }

                    System.out.println("Usuário encontrado: " + usuarioEncontrado.get().getName());
                    System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
                    String ids = scanner.nextLine();

                    List<Optional<Product>> listaProdutos = listaDeProdutos.findMultipleIds(ids);
                    if (listaProdutos.stream().allMatch(p -> !p.isPresent())) {
                        System.out.println("Nenhum produto válido encontrado!");
                        break;
                    }

                    double valorTotal = 0;
                    System.out.println("Produtos encontrados:");
                    for (Optional<Product> optProduto : listaProdutos) {
                        if (optProduto.isPresent()) {
                            Product produto = optProduto.get();
                            valorTotal += produto.getPrice();
                            System.out.println("- " + produto.getName() + " (R$ " + produto.getPrice() + ")");
                        }
                    }

                    System.out.println("Selecione uma forma de pagamento: ");
                    System.out.println("1 - Cartão de Crédito\n2 - Boleto\n3 - PIX\nOpção: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    String pagamento;
                    if (opcao == 1) {
                        formaPagamento.setPaymentMethod(PaymentMethodFactory.create(PaymentType.CARTAO));
                        pagamento = "Cartão de Crédito";
                    } else if (opcao == 2) {
                        formaPagamento.setPaymentMethod(PaymentMethodFactory.create(PaymentType.BOLETO));
                        pagamento = "Boleto";
                    } else if (opcao == 3) {
                        formaPagamento.setPaymentMethod(PaymentMethodFactory.create(PaymentType.PIX));
                        pagamento = "PIX";
                    } else {
                        System.out.println("Opção inválida. Saindo da venda...");
                        break;
                    }

                    formaPagamento.pay(valorTotal);
                    listaDeVendas.save(new Venda(usuarioEncontrado.get().getUuid(), pagamento, LocalDateTime.now()));

                    System.out.println("Resumo da venda:");
                    System.out.println("Cliente: " + usuarioEncontrado.get().getName());
                    listaProdutos.stream().filter(Optional::isPresent).forEach(p -> System.out.println(p.get()));
                    System.out.println("Valor total: R$ " + valorTotal);
                    System.out.println("Método de pagamento: " + pagamento);
                    System.out.println("Venda salva com sucesso!");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 6);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}