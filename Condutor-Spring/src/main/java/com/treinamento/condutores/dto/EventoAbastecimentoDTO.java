package com.treinamento.condutores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import com.treinamento.condutores.model.EventoAbastecimentoModel;
import com.treinamento.condutores.model.VeiculoModel;

import condutores.enums.TipoEvento;
import condutores.enums.TipoCombustivel;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoAbastecimentoDTO {

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

	@NotNull
	private TipoCombustivel tipoCombustivel;

	@NotNull
	private Double valorLitro;

	@NotNull
	private Double litros;

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

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Double valorLitro) {
		this.valorLitro = valorLitro;
	}

	public Double getLitros() {
		return litros;
	}

	public void setLitros(Double litros) {
		this.litros = litros;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public EventoAbastecimentoModel toEntity() {
		EventoAbastecimentoModel entity = new EventoAbastecimentoModel();

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);
		entity.setTipoEvento(this.tipoEvento);

		entity.setHodometro(this.hodometro);
		entity.setTipoCombustivel(this.tipoCombustivel);
		entity.setValorLitro(this.valorLitro);
		entity.setLitros(this.litros);

		VeiculoModel v = new VeiculoModel();
		v.setCodigo(this.codigoVeiculo);

		entity.setVeiculo(v);

		return entity;
	}
}