package condutores.enums;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public enum TipoEvento {
	ABASTECIMENTO("Abastecimento"),
	ENTRADA("Entrada"),
	SAIDA("Saída"),
	MULTA("Descrição"),
	MANUTENCAO("Manutenção"),
	SINISTRO("Sinistro");

	private final String descricao;

	TipoEvento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
