package com.treinamento.condutores.dto;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;

import com.treinamento.condutores.model.EventoEntradaSaidaModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.model.CondutorModel;

public class EventoEntradaSaidaDTO {

	private Long codigoEvento;

	public Long getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(Long codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@NotNull
	private Date dataHora;

	@NotBlank
	private String local;

	private String observacao;

	@NotNull
	private Long codigoVeiculo;

	public Long getCodigoCondutor() {
		return codigoCondutor;
	}

	public void setCodigoCondutor(Long codigoCondutor) {
		this.codigoCondutor = codigoCondutor;
	}

	public Long getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(Long codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	@NotNull
	private Long codigoCondutor;

	@NotNull
	private TipoMovimento tipoMovimento;

	@NotNull
	private TipoEvento tipoEvento;

	public EventoEntradaSaidaDTO() {
	}

	public EventoEntradaSaidaModel toEntity() {
		EventoEntradaSaidaModel entity = new EventoEntradaSaidaModel();

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);
		entity.setTipoEvento(this.tipoEvento);
		entity.setTipoMovimento(this.tipoMovimento);

		VeiculoModel v = new VeiculoModel();
		v.setCodigo(this.codigoVeiculo);

		CondutorModel c = new CondutorModel();
		c.setCodigo(this.codigoCondutor);

		entity.setVeiculo(v);
		entity.setCondutor(c);

		return entity;
	}

}
