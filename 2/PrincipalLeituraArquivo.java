package pjrLeituraEscrita;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalLeituraArquivo {
    public static void LerArquivo() {
        try {
            FileReader leitura = new FileReader("agenda.txt");
            BufferedReader brLeitura = new BufferedReader(leitura);

            System.out.println("----- Contatos da Agenda -----");
            while (brLeitura.ready()) {
                String str = brLeitura.readLine();
                String[] dados = str.split(";");
                if (dados.length == 2) {
                    String nome = dados[0];
                    String numero = dados[1];
                    System.out.println("Nome: " + nome + " | Telefone: " + numero);
                } else {
                    System.out.println("Linha inválida: " + str);
                }
            }

            brLeitura.close();
            leitura.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
