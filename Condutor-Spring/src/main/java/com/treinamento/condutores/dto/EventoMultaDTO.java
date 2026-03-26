package com.treinamento.condutores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.math.BigDecimal;

import condutores.enums.TipoEvento;
import condutores.enums.TipoInfracao;

import com.treinamento.condutores.model.EventoMultaModel;
import com.treinamento.condutores.model.VeiculoModel;
import com.treinamento.condutores.model.CondutorModel;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoMultaDTO {

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
	private TipoInfracao tipoInfracao;

	@NotNull
	private Integer pontosCnh;

	@NotNull
	private BigDecimal valorMulta;

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

	public TipoInfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	public Integer getPontosCnh() {
		return pontosCnh;
	}

	public void setPontosCnh(Integer pontosCnh) {
		this.pontosCnh = pontosCnh;
	}

	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public EventoMultaDTO() {
	}

	public EventoMultaModel toEntity() {
		EventoMultaModel entity = new EventoMultaModel();

		entity.setCodigo(this.codigoEvento);
		entity.setDataHora(this.dataHora);
		entity.setLocal(this.local);
		entity.setObservacao(this.observacao);
		entity.setTipoEvento(this.tipoEvento);

		entity.setTipoInfracao(this.tipoInfracao);
		entity.setPontosCnh(this.pontosCnh);
		entity.setValorMulta(this.valorMulta.doubleValue());

		VeiculoModel v = new VeiculoModel();
		v.setCodigo(this.codigoVeiculo);

		CondutorModel c = new CondutorModel();
		c.setCodigo(this.codigoCondutor);

		entity.setVeiculo(v);
		entity.setCondutor(c);

		return entity;
	}
}