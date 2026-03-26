package com.treinamento.condutores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import com.treinamento.condutores.model.CondutorModel;
import com.treinamento.condutores.model.EventoSinistroModel;
import com.treinamento.condutores.model.VeiculoModel;

import condutores.enums.TipoEvento;

public class EventoSinistroDTO {

	private Long codigoEvento;

	@NotNull
	private Date dataHora;

	@NotBlank
	private String local;

	private String observacao;

	@NotNull
	private Long codigoVeiculo;

	@NotNull
	private Long codigoCondutor;

	@NotNull
	private Boolean houveVitimas;

	@NotNull
	private Boolean houveEnvolvidos;

	private String laudo;

	@NotNull
	private TipoEvento tipoEvento;


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

	public Long getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(Long codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public Long getCodigoCondutor() {
		return codigoCondutor;
	}

	public void setCodigoCondutor(Long codigoCondutor) {
		this.codigoCondutor = codigoCondutor;
	}

	public Boolean getHouveVitimas() {
		return houveVitimas;
	}

	public void setHouveVitimas(Boolean houveVitimas) {
		this.houveVitimas = houveVitimas;
	}

	public Boolean getHouveEnvolvidos() {
		return houveEnvolvidos;
	}

	public void setHouveEnvolvidos(Boolean houveEnvolvidos) {
		this.houveEnvolvidos = houveEnvolvidos;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}


	public EventoSinistroModel toEntity() {
		EventoSinistroModel entity = new EventoSinistroModel();

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);
		entity.setTipoEvento(this.tipoEvento);

		entity.setHouveVitimas(this.houveVitimas);
		entity.setHouveEnvolvidos(this.houveEnvolvidos);
		entity.setLaudo(this.laudo);

		VeiculoModel v = new VeiculoModel();
		v.setCodigo(this.codigoVeiculo);

		CondutorModel c = new CondutorModel();
		c.setCodigo(this.codigoCondutor);

		entity.setVeiculo(v);
		entity.setCondutor(c);

		return entity;
	}
}