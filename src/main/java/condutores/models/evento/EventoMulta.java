package condutores.models.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_MANUTENCAO;
import static condutores.util.Tabelas.EVENTOS_MULTA;
import condutores.enums.TipoEvento;
import condutores.enums.TipoInfracao;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.util.Tabelas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Entity
@Table(name = EVENTOS_MULTA)
@PrimaryKeyJoinColumn(name = "codigoEvento")
public class EventoMulta extends Evento {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private Condutor condutor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoInfracao tipoInfracao;

	@Column(nullable = false)
	private Integer pontosCnh;
	
	@Column(nullable = false)
	private Double valorMulta;

	public EventoMulta() {

	}

	public EventoMulta(Date dataHora, String local, String observacao, Veiculo veiculo, Condutor condutor, TipoInfracao tipoInfracao, Integer pontosCnh, double valorMulta, TipoEvento tipoEvento) {
		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.condutor = condutor;
		this.tipoInfracao = tipoInfracao;
		this.pontosCnh = pontosCnh;
		this.valorMulta = valorMulta;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public TipoInfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	public Integer getPontosCnh() {
		return pontosCnh;
	}

	public void setPontosCnh(Integer pontosCnh) {
		this.pontosCnh = pontosCnh;
	}

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("#####$ EVENTO: MULTAS $#####");

		System.out.println("Condutor: " + condutor.getNome());
		System.out.println("Tipo da Infração: " + tipoInfracao);
		System.out.println("Pontos da Infração " + pontosCnh);
		System.out.println("Valor Multa: " + valorMulta);
		System.out.println();

		System.out.println("#####$ EVENTO MULTAS -SAIDA : DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}
