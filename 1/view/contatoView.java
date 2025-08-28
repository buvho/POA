package view;

import java.util.Scanner;
import controller.ContatoController;

public class contatoView {
    public static void main(String[] args) {
        ContatoController controle = new ContatoController();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Lista Telefônica:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Alterar Contato");
            System.out.println("4. Excluir Contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    controle.adicionarContato(nome, telefone, email);
                    break;
                case 2:
                    controle.listarContatos();
                    break;
                case 3:
                    System.out.print("Telefone do contato a alterar: ");
                    String telAlterar = scanner.nextLine();
                    controle.alterarContato(telAlterar);
                    break;
                case 4:
                    System.out.print("Telefone do contato a excluir: ");
                    String telExcluir = scanner.nextLine();
                    controle.excluirContato(telExcluir);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}