package com.treinamento.condutores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import condutores.enums.TipoInfracao;
import condutores.util.Tabelas;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Entity
@Table(name = Tabelas.EVENTOS_MULTA)
@Inheritance(strategy = InheritanceType.JOINED)

public class EventoMultaModel extends EventoModel {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private CondutorModel condutor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private condutores.enums.TipoInfracao tipoInfracao;

	@Column(nullable = false)
	private Integer pontosCnh;

	@Column(nullable = false)
	private Double valorMulta;

	public CondutorModel getCondutor() {
		return condutor;
	}

	public void setCondutor(CondutorModel condutor) {
		this.condutor = condutor;
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

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public EventoMultaModel() {
	}

	public EventoMultaModel(Date dataHora, String local, String observacao, VeiculoModel veiculo, CondutorModel condutor, condutores.enums.TipoInfracao tipoInfracao, Integer pontosCnh, double valorMulta, condutores.enums.TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.condutor = condutor;
		this.tipoInfracao = tipoInfracao;
		this.pontosCnh = pontosCnh;
		this.valorMulta = valorMulta;
	}
}

