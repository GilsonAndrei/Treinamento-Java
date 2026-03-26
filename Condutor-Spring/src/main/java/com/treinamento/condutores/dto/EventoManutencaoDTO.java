
package com.treinamento.condutores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import com.treinamento.condutores.model.EventoManutencaoModel;
import com.treinamento.condutores.model.VeiculoModel;

import condutores.enums.TipoEvento;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoManutencaoDTO {

	private Long codigoEvento;

	@NotNull
	private Date dataHora;

	@NotBlank
	private String local;

	private String observacao;

	@NotNull
	private Long codigoVeiculo;

	@NotNull
	private Double hodometro;

	@NotBlank
	private String servicosRealizados;

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

	public Double getHodometro() {
		return hodometro;
	}

	public void setHodometro(Double hodometro) {
		this.hodometro = hodometro;
	}

	public String getServicosRealizados() {
		return servicosRealizados;
	}

	public void setServicosRealizados(String servicosRealizados) {
		this.servicosRealizados = servicosRealizados;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public EventoManutencaoModel toEntity() {
		EventoManutencaoModel entity = new EventoManutencaoModel();

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);
		entity.setTipoEvento(this.tipoEvento);

		entity.setHodometro(this.hodometro);
		entity.setServicosRealizados(this.servicosRealizados);

		VeiculoModel v = new VeiculoModel();
		v.setCodigo(this.codigoVeiculo);

		entity.setVeiculo(v);

		return entity;
	}
}
