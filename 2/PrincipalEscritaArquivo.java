package pjrLeituraEscrita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalEscritaArquivo {
    public static void EscreverArquivo(Scanner sc) {
        try {
            FileWriter escrita = new FileWriter("agenda.txt", true); // true = acrescenta no arquivo
            BufferedWriter bwEscrita = new BufferedWriter(escrita);

            System.out.println("----- Cadastro de Contato -----");
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = sc.nextLine();

            bwEscrita.write(nome + ";" + telefone);
            bwEscrita.newLine();

            System.out.println("Contato salvo com sucesso!");

            bwEscrita.close();
            escrita.close();

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
