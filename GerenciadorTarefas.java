package trabalhoPOO2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerenciadorTarefas {

	private ArrayList<Tarefa> tarefasPendentes;
	private ArrayList<Tarefa> tarefasConcluidas;

	public GerenciadorTarefas() {
		this.tarefasPendentes = new ArrayList<>();
		this.tarefasConcluidas = new ArrayList<>();
	}

	public ArrayList<Tarefa> getTarefasPendentes(){
		return tarefasPendentes;
	}

	public void setTarefasPendentes(ArrayList<Tarefa> tarefasPendentes){
		this.tarefasPendentes = tarefasPendentes;
	}

	public ArrayList<Tarefa> getTarefasConcluidas() {
		return tarefasConcluidas;
	}

	public void setTarefasConcluidas(ArrayList<Tarefa> tarefasConcluidas) {
		this.tarefasConcluidas = tarefasConcluidas;
	}

	public void addTarefasPendentes() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a descrição da tarefa:");
		String descricao = sc.nextLine();

		System.out.println("Digite a data de vencimento (dd/mm/aaaa):");
		String dataVencimento = sc.nextLine();

		Tarefa tarefa = new Tarefa(descricao, dataVencimento, null, null, "Pendente");
		this.tarefasPendentes.add(tarefa);

		// Escreve no arquivo tarefasPendentes.txt
		try {
			FileWriter fw = new FileWriter("tarefasPendentes.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(tarefa.toString());
			pw.close();
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo.");
			e.printStackTrace();
		}

		System.out.println("Tarefa adicionada com sucesso!");
	}

	public void addTarefasConcluidas(Tarefa tarefaPendente) {
		tarefaPendente.setStatus("Concluído");
		this.tarefasConcluidas.add(tarefaPendente);

		// Remove a tarefa pendente do array tarefasPendentes
		this.tarefasPendentes.remove(tarefaPendente);

		// Atualiza o arquivo tarefasPendentes.txt
		try {
			FileWriter fw = new FileWriter("tarefasPendentes.txt", false);
			PrintWriter pw = new PrintWriter(fw);
			for (Tarefa t : this.tarefasPendentes) {
				pw.println(t.toString());
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo.");
			e.printStackTrace();
		}

		System.out.println("Tarefa concluída com sucesso!");
	}

	public void exibirTarefasPendentes() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tarefasPendentes.txt"));
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");
				String descricao = dados[0];
				String dataVencimento = dados[1];
				String status = dados[2];
				Tarefa tarefa = new Tarefa(descricao, dataVencimento, null, null, status);
				System.out.println(tarefa.toString());
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
			e.printStackTrace();
		}
	}

	public void exibirTarefasConcluidas() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tarefasConcluidas.txt"));
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");
				String descricao = dados[0];
				String dataVencimento = dados[1];
				String status = dados[2];
				Tarefa tarefa = new Tarefa(descricao, dataVencimento, null, null, status);
				System.out.println(tarefa.toString());
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
			e.printStackTrace();
		}
	}

}
