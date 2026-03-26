package condutores.enums;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public enum TipoInfracao {
	LEVE("Leve"),
	MEDIA("Média"),
	GRAVE("Grave"),
	GRAVISSIMA("Gravissíma");
	
	private final String descricao;

	TipoInfracao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
