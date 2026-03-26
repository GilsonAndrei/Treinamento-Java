package com.treinamento.condutores.model;

import condutores.enums.TipoCombustivel;
import condutores.enums.TipoEvento;

import condutores.util.Tabelas;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = Tabelas.EVENTOS_ABASTECIMENTO)
@PrimaryKeyJoinColumn(name = "codigoEvento")
/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoAbastecimentoModel extends EventoModel {

	@Column(nullable = false)
	private Double hodometro;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoCombustivel tipoCombustivel;

	@Column(nullable = false)
	private Double valorLitro;

	@Column(nullable = false)
	private Double litros;

	public EventoAbastecimentoModel() {
	}

	public EventoAbastecimentoModel(Date dataHora, String local, String observacao,
	                                VeiculoModel veiculo,
	                                Double hodometro,
	                                TipoCombustivel tipoCombustivel,
	                                Double valorLitro,
	                                Double litros,
	                                TipoEvento tipoEvento) {

		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.hodometro = hodometro;
		this.tipoCombustivel = tipoCombustivel;
		this.valorLitro = valorLitro;
		this.litros = litros;
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
}
