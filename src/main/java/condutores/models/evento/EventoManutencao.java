package condutores.models.evento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_ENTRADA_SAIDA;
import static condutores.util.Tabelas.EVENTOS_MANUTENCAO;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;
import condutores.util.Tabelas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Entity
@Table(name = EVENTOS_MANUTENCAO)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoManutencao extends Evento {

	@Column(nullable = false)
	private Double hodometro;

	@Column(nullable = false, length = 1000)
	private String servicosRealizados;

	public EventoManutencao() {

	}

	public EventoManutencao(Date dataHora, String local, String observacao, Veiculo veiculo,
	                        Double hodometro, String servicosRealizados, TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.hodometro = hodometro;
		this.servicosRealizados = servicosRealizados;
	}

	public Double getHodometro() {
		return hodometro;
	}

	public void setHodometro(Double hodometro) {
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
