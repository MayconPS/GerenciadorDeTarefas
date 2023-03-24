package trabalhoPOO2;

import java.util.Date;
import java.util.Objects;

public class Tarefa {

	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private Date dataConclusao;
	private String status;
	
	// criação do construtor
	public Tarefa() {
		
	}
	
	public Tarefa(String titulo, String descricao, Date dataCriacao, Date dataConclusao, String status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataConclusao = dataConclusao;
		this.status = status;
	}
	
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	// sobrescrevendo metodo equals para fazer comparação dentro do arrayList
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(dataConclusao, other.dataConclusao) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(status, other.status)
				&& Objects.equals(titulo, other.titulo);
	}
	//sobrescrevendo toString pra imprimir como eu quero
	@Override
	public String toString() {
		return "Tarefa [titulo=" + titulo + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao
				+ ", dataConclusao=" + dataConclusao + ", status=" + status + "]";
	}
	
}
