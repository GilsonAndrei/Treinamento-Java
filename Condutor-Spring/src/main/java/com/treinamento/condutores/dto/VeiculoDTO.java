package com.treinamento.condutores.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.treinamento.condutores.model.VeiculoModel;

import condutores.enums.TipoControle;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class VeiculoDTO {
	private Long codigo;

	@NotBlank(message = "Placa é obrigatória!")
	private String placa;

	@NotBlank(message = "Marca/Modelo é obrigatório!")
	private String marcaModelo;

	@NotNull(message = "Ano de fabricação é obrigatório!")
	@Min(value = 1886, message = "Ano deve ser >= 1886")
	private Integer anoFabricacao;

	private Date dataAquisicao;

	@NotBlank(message = "Tipo de controle é obrigatório!")
	private String tipoControle;

	@NotNull(message = "Hodômetro é obrigatório!")
	private Double hodometro;

	public VeiculoDTO() {
	}

	public VeiculoModel toEntity() {
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setCodigo(codigo);
		veiculo.setPlaca(placa);
		veiculo.setMarcaModelo(marcaModelo);
		veiculo.setAnoFabricacao(anoFabricacao);
		veiculo.setDataAquisicao(dataAquisicao);
		veiculo.setTipoControle(TipoControle.valueOf(tipoControle));
		veiculo.setHodometro(hodometro);
		return veiculo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getTipoControle() {
		return tipoControle;
	}

	public void setTipoControle(String tipoControle) {
		this.tipoControle = tipoControle;
	}

	public Double getHodometro() {
		return hodometro;
	}

	public void setHodometro(Double hodometro) {
		this.hodometro = hodometro;
	}
}
