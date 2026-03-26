package com.treinamento.condutores.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

import com.treinamento.condutores.model.EventoModel;
import com.treinamento.condutores.model.VeiculoModel;

import condutores.enums.TipoEvento;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class EventoDTO {

	private Long codigoEvento;

	@NotNull(message = "Data e hora são obrigatórias")
	private Date dataHora;

	@NotBlank(message = "Local é obrigatório")
	private String local;

	private String observacao;

	@NotNull(message = "Veículo é obrigatório")
	private Long codigoVeiculo;

	@NotNull(message = "Tipo do evento é obrigatório")
	private TipoEvento tipoEvento;

	public EventoDTO() {
	}

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

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public EventoModel toEntity() {

		EventoModel entity = new EventoModel() {
		};

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);

		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setCodigo(this.codigoVeiculo);

		entity.setVeiculo(veiculo);
		entity.setTipoEvento(this.tipoEvento);

		return entity;
	}
}