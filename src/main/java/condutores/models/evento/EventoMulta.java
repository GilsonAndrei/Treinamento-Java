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

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoMulta extends Evento {
	private Long codigo;
	private Condutor condutor;
	private TipoInfracao tipoInfracao;
	private Integer pontosCnh;
	private Double valorMulta;

	public EventoMulta() {

	}

	public EventoMulta(Long codigo, Date dataHora, String local, String observacao, Veiculo veiculo, Condutor condutor, TipoInfracao tipoInfracao, Integer pontosCnh, double valorMulta, TipoEvento tipoEvento) {
		super(codigo, dataHora, local, observacao, veiculo, tipoEvento);
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
