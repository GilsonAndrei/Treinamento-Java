package condutores.models.evento;


import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.util.Tabelas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_ABASTECIMENTO;
import static condutores.util.Tabelas.EVENTOS_ENTRADA_SAIDA;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Entity
@Table(name = EVENTOS_ENTRADA_SAIDA)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoEntradaSaida extends Evento {
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoMovimento tipo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private Condutor condutor;

	public EventoEntradaSaida() {

	}

	public EventoEntradaSaida(Date dataHora, String local, String observacao, Veiculo veiculo,
	                          TipoMovimento tipo, Condutor condutor, TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
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
