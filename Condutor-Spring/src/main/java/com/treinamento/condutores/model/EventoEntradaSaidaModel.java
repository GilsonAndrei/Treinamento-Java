package com.treinamento.condutores.model;

import javax.persistence.PrimaryKeyJoinColumn;

import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_ENTRADA_SAIDA;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Entity
@Table(name = EVENTOS_ENTRADA_SAIDA)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoEntradaSaidaModel extends EventoModel {

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoMovimento", nullable = false, length = 20)
	private TipoMovimento tipoMovimento;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private CondutorModel condutor;

	public EventoEntradaSaidaModel() {
	}

	public EventoEntradaSaidaModel(Date dataHora, String local, String observacao,
	                               VeiculoModel veiculo, TipoMovimento tipoMovimento,
	                               CondutorModel condutor, TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.tipoMovimento = tipoMovimento;
		this.condutor = condutor;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public CondutorModel getCondutor() {
		return condutor;
	}

	public void setCondutor(CondutorModel condutor) {
		this.condutor = condutor;
	}
}