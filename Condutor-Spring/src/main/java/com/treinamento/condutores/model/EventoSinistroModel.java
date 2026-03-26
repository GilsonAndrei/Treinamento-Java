package com.treinamento.condutores.model;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.*;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Entity
@Table(name = condutores.util.Tabelas.EVENTOS_SINISTRO)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoSinistroModel extends EventoModel {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private CondutorModel condutor;

	@Column(nullable = false)
	private boolean houveVitimas;

	@Column(nullable = false)
	private boolean houveEnvolvidos;

	@Column(length = 1000)
	private String laudo;

	public EventoSinistroModel() {
	}

	public EventoSinistroModel(Date dataHora,
	                           String local,
	                           String observacao,
	                           VeiculoModel veiculo,
	                           CondutorModel condutor,
	                           boolean houveVitimas,
	                           boolean houveEnvolvidos,
	                           String laudo,
	                           condutores.enums.TipoEvento tipoEvento) {

		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.condutor = condutor;
		this.houveVitimas = houveVitimas;
		this.houveEnvolvidos = houveEnvolvidos;
		this.laudo = laudo;
	}

	public CondutorModel getCondutor() {
		return condutor;
	}

	public void setCondutor(CondutorModel condutor) {
		this.condutor = condutor;
	}

	public boolean isHouveVitimas() {
		return houveVitimas;
	}

	public void setHouveVitimas(boolean houveVitimas) {
		this.houveVitimas = houveVitimas;
	}

	public boolean isHouveEnvolvidos() {
		return houveEnvolvidos;
	}

	public void setHouveEnvolvidos(boolean houveEnvolvidos) {
		this.houveEnvolvidos = houveEnvolvidos;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}
}
