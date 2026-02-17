package condutores.models.evento;


import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoEntradaSaida extends Evento {
	private TipoMovimento tipo;
	private Condutor condutor;

	public EventoEntradaSaida() {

	}

	public EventoEntradaSaida(Date dataHora, String local, String observacao, Veiculo veiculo,
	                          TipoMovimento tipo, Condutor condutor) {
		super(dataHora, local, observacao, veiculo);
		this.tipo = tipo;
		this.condutor = condutor;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
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
		System.out.println("Condutorr: " + condutor.getNome());
		System.out.println("CPF: " + condutor.getCpf());
		System.out.println();

		System.out.println("#####$ EVENTO ENTRADA -SAIDA : DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}
