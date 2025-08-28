package pjrLeituraEscrita;

import java.util.Scanner;
import PrincipalEscritaArquivo;
import PrincipalLeituraArquivo;

public class Main {
    public static void main(String[] args) {
        boolean executando = true;
        Scanner sc = new Scanner(System.in);
        while (executando) {
            System.out.println("\n----- MENU AGENDA TELEFÔNICA -----");
            System.out.println("1 - Cadastrar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            String opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    PrincipalEscritaArquivo.EscreverArquivo(sc);
                    break;
                case "2":
                    PrincipalLeituraArquivo.LerArquivo();
                    break;
                case "0":
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
         sc.close();
    }
}
