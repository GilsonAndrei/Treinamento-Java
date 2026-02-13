package condutores.models.evento;

import java.util.Date;

import condutores.enums.TipoInfracao;
import condutores.models.Condutor;
import condutores.models.Veiculo;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoMulta extends Evento {
	private Condutor condutor;
	private TipoInfracao tipoInfracao;
	private int pontosCnh;
	private double valorMulta;

	public EventoMulta(Date dataHora, String local, String observacao, Veiculo veiculo, Condutor condutor, TipoInfracao tipoInfracao, int pontosCnh, double valorMulta) {
		super(dataHora, local, observacao, veiculo);
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

	public int getPontosCnh() {
		return pontosCnh;
	}

	public void setPontosCnh(int pontosCnh) {
		this.pontosCnh = pontosCnh;
	}

	public double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(double valorMulta) {
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
