package condutores.enums;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public enum TipoMovimento {
	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private final String descricao;

	TipoMovimento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
