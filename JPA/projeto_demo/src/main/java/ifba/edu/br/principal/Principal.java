package main.java.ifba.edu.br.principal;

import ifba.edu.br.basica.Cliente;
import ifba.edu.br.basica.Categoria;
import ifba.edu.br.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = GetEntityManager.getConnectionJpa();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu de Opções ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Excluir Cliente");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o enter

            switch (opcao) {
                case 1:
                    cadastrarCliente(em, scanner);
                    break;
                case 2:
                    editarCliente(em, scanner);
                    break;
                case 3:
                    excluirCliente(em, scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    em.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(EntityManager em, Scanner scanner) {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        System.out.print("ID da Categoria: ");
        int categoriaId = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter

        Categoria categoria = em.find(Categoria.class, categoriaId);
        if (categoria == null) {
            System.out.println("Categoria não encontrada. Cadastro cancelado.");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setRg(rg);
        cliente.setCategoria(categoria);

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void editarCliente(EntityManager em, Scanner scanner) {
        System.out.println("\n=== Edição de Cliente ===");
        System.out.print("ID do Cliente a ser editado: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter

        Cliente cliente = em.find(Cliente.class, clienteId);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Edição cancelada.");
            return;
        }

        System.out.print("Novo Nome (atual: " + cliente.getNome() + "): ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo CPF (atual: " + cliente.getCpf() + "): ");
        String novoCpf = scanner.nextLine();
        System.out.print("Novo RG (atual: " + cliente.getRg() + "): ");
        String novoRg = scanner.nextLine();

        em.getTransaction().begin();
        cliente.setNome(novoNome);
        cliente.setCpf(novoCpf);
        cliente.setRg(novoRg);
        em.getTransaction().commit();
        System.out.println("Cliente editado com sucesso!");
    }

    private static void excluirCliente(EntityManager em, Scanner scanner) {
        System.out.println("\n=== Exclusão de Cliente ===");
        System.out.print("ID do Cliente a ser excluído: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter

        Cliente cliente = em.find(Cliente.class, clienteId);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Exclusão cancelada.");
            return;
        }

        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        System.out.println("Cliente excluído com sucesso!");
    }
}
