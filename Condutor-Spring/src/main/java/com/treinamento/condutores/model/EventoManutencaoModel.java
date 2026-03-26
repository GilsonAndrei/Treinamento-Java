package com.treinamento.condutores.model;

import javax.persistence.PrimaryKeyJoinColumn;

import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static condutores.util.Tabelas.EVENTOS_MANUTENCAO;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Entity
@Table(name = EVENTOS_MANUTENCAO)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoManutencaoModel extends EventoModel {
	@Column(nullable = false)
	private Double hodometro;

	@Column(nullable = false, length = 1000)
	private String servicosRealizados;

	public EventoManutencaoModel() {

	}

	public EventoManutencaoModel(Date dataHora, String local, String observacao, VeiculoModel veiculo,
	                             Double hodometro, String servicosRealizados, condutores.enums.TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.hodometro = hodometro;
		this.servicosRealizados = servicosRealizados;
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
}
