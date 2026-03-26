package br.com.gaos.exerciciossb.models;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Cliente {
	private Integer id;
	private String nome;
	private String cpf;

	public Cliente(Integer id ,String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
