package condutores.models.evento;


import java.util.Date;

import condutores.models.Veiculo;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoManutencao extends Evento {
	private double hodometro;
	private String servicosRealizados;

	public EventoManutencao(Date dataHora, String local, String observacao, Veiculo veiculo,
	                        double hodometro, String servicosRealizados) {
		super(dataHora, local, observacao, veiculo);
		this.hodometro = hodometro;
		this.servicosRealizados = servicosRealizados;
	}

	public double gethodometro() {
		return hodometro;
	}

	public void sethodometro(double hodometro) {
		this.hodometro = hodometro;
	}

	public String getServicosRealizados() {
		return servicosRealizados;
	}

	public void setServicosRealizados(String servicosRealizados) {
		this.servicosRealizados = servicosRealizados;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("#####$ EVENTO: MANUTENÇÃO $#####");
		System.out.println("Marcador no Momento: " + hodometro);
		System.out.println("Serviços Realizados: " + servicosRealizados);
		System.out.println();

		System.out.println("#####$ EVENTO MANUTENÇÃO : DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}
