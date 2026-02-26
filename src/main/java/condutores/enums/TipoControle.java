package condutores.enums;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public enum TipoControle {
	HORAS("Horas"),
	QUILOMETROS("Quilômetros");
	
	private final String descricao;

	TipoControle(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
