package condutores.models.evento;


import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_ABASTECIMENTO;
import static condutores.util.Tabelas.EVENTOS_ENTRADA_SAIDA;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoEntradaSaida extends Evento {
	private Long codigo;
	private TipoMovimento tipo;
	private Condutor condutor;

	public EventoEntradaSaida() {

	}

	public EventoEntradaSaida(Long codigo, Date dataHora, String local, String observacao, Veiculo veiculo,
	                          TipoMovimento tipo, Condutor condutor, TipoEvento tipoEvento) {
		super(codigo, dataHora, local, observacao, veiculo, tipoEvento);
		this.tipo = tipo;
		this.condutor = condutor;
	}

	public TipoMovimento getTipoMovimento() {
		return tipo;
	}

	public void setTipoMovimento(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("#####$ EVENTO: ENTRADA -SAIDA  $#####");
		System.out.println("Tipo: " + tipo);
		System.out.println("Condutor: " + condutor.getNome());
		System.out.println("CPF: " + condutor.getCpf());
		System.out.println();

		System.out.println("#####$ EVENTO ENTRADA -SAIDA : DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}
