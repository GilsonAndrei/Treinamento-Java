package condutores.enums;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public enum TipoCombustivel {

	GASOLINA("Gasolina"),
	DIESEL("Diesel"),
	ETANOL("Etanol");

	private final String descricao;

	TipoCombustivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
