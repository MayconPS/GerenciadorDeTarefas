package trabalhoPOO2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    GerenciadorTarefas gerenciador = new GerenciadorTarefas();
	    Scanner scanner = new Scanner(System.in);
	    int opcao = 0;
	    
	    // Lê as tarefas pendentes salvas no arquivo
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("tarefasPendentes.txt"));
	        String linha;
	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(";");
	            String descricao = dados[0];
	            String dataConclusao = dados[1];
	            String status = dados[2];
	            Tarefa tarefa = new Tarefa(descricao, dataConclusao, null, null, status);
	            gerenciador.addTarefasPendentes(); // Adiciona a tarefa na lista de tarefas pendentes
	        }
	        br.close();
	    } catch (IOException e) {
	        System.out.println("Erro ao ler o arquivo.");
	        e.printStackTrace();
	    }
	    
	    do {
	        System.out.println("Gerenciador de Tarefas");
	        System.out.println("-------------------------");
	        System.out.println("1 - Adicionar tarefa pendente");
	        System.out.println("2 - Adicionar tarefa concluída");
	        System.out.println("3 - Exibir tarefas pendentes");
	        System.out.println("4 - Exibir tarefas concluídas");
	        System.out.println("0 - Sair");
	        System.out.print("Digite a opção desejada: ");
	        opcao = scanner.nextInt();
	        scanner.nextLine(); // consome a quebra de linha após a opção digitada

	        switch (opcao) {
	            case 1:
	                gerenciador.addTarefasPendentes();
	                break;
	            case 2:
	                System.out.print("Digite o índice da tarefa pendente a ser concluída: ");
	                int indice = scanner.nextInt();
	                scanner.nextLine(); // consome a quebra de linha após o índice digitado
	                if (indice >= 0 && indice < gerenciador.getTarefasPendentes().size()) {
	                    Tarefa tarefa = gerenciador.getTarefasPendentes().get(indice);
	                    gerenciador.addTarefasConcluidas(tarefa);
	                } else {
	                    System.out.println("Índice inválido!");
	                }
	                break;
	            case 3:
	                System.out.println("Tarefas pendentes:");
	                gerenciador.exibirTarefasPendentes();
	                break;
	            case 4:
	                System.out.println("Tarefas concluídas:");
	                gerenciador.exibirTarefasConcluidas();
	                break;
	            case 0:
	                System.out.println("Encerrando o programa...");
	                break;
	            default:
	                System.out.println("Opção inválida!");
	                break;
	        }
	        System.out.println();
	    } while (opcao != 0);
	    
	    // Atualiza o arquivo tarefasPendentes.txt com as tarefas pendentes restantes
	    try {
	        FileWriter fw = new FileWriter("tarefasPendentes.txt", false);
	        PrintWriter pw = new PrintWriter(fw);
	        for (Tarefa t : gerenciador.getTarefasPendentes()) {
	            pw.println(t.toString());
	        }
	        pw.close();
	    } catch (IOException e) {
	        System.out.println();
	    } while (opcao != 0);

	    scanner.close();
	}
	
}
