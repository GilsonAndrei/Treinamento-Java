package condutores.models;


import condutores.enums.TipoControle;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Veiculo {

	private Long codigo;
	private Date dataAquisicao;
	private Integer anoFabricacao;
	private String placa;
	private String marcaModelo;
	private TipoControle tipoControle;
	private Double hodometro;

	public Veiculo() {

	}

	public Veiculo(Long codigo, Date dataAquisicao, Integer anoFabricacao, String placa, String marcaModelo, TipoControle tipoControle, Double hodometro) {
		this.codigo = codigo;
		this.dataAquisicao = dataAquisicao;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.marcaModelo = marcaModelo;
		this.tipoControle = tipoControle;
		this.hodometro = hodometro;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
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

	public TipoControle getTipoControle() {
		return tipoControle;
	}

	public void setTipoControle(TipoControle tipoControle) {
		this.tipoControle = tipoControle;
	}

	public Double getHodometro() {
		return hodometro;
	}

	public void setHodometro(Double hodometro) {
		this.hodometro = hodometro;
	}

	public void exibirDetalhes() {
		System.out.println("#####$ VEÍCULO $#####");
		System.out.println("Código: " + codigo);
		System.out.println("Data aquisição: " + dataAquisicao);
		System.out.println("Ano fabricação: " + anoFabricacao);
		System.out.println("Placa: " + placa);
		System.out.println("Marca/Modelo: " + marcaModelo);
		System.out.println("Tipo controle: " + tipoControle);
		System.out.println("Hodômetro/Horímetro: " + hodometro);
		System.out.println();
	}
}
