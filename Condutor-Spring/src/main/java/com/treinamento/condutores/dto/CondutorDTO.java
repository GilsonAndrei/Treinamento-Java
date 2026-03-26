package com.treinamento.condutores.dto;

import javax.validation.constraints.NotBlank;

import java.util.Date;

import com.treinamento.condutores.model.CondutorModel;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CondutorDTO {

	private Long codigo;

	@NotBlank(message = "CPF é obrigatório")
	private String cpf;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	private Date dataNascimento;

	@NotBlank(message = "Número CNH é obrigatório")
	private String numeroCNH;

	@NotBlank(message = "Categoria CNH é obrigatória")
	private String categoriaCNH;

	private Date dataVencimento;

	public CondutorDTO() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public String getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public CondutorModel toEntity() {
		CondutorModel entity = new CondutorModel();
		entity.setCodigo(this.codigo);
		entity.setCpf(this.cpf);
		entity.setNome(this.nome);
		entity.setDataNascimento(this.dataNascimento);
		entity.setNumeroCNH(this.numeroCNH);
		entity.setCategoriaCNH(this.categoriaCNH);
		entity.setDataVencimento(this.dataVencimento);
		return entity;
	}
}
