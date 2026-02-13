package condutores.models.evento;

import condutores.enums.TipoCombustivel;
import condutores.models.Veiculo;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class EventoAbastecimento extends Evento {
	private double hodometro;
	private TipoCombustivel tipoCombustivel;
	private double valorLitro;
	private double litros;

	public EventoAbastecimento(Date dataHora, String local, String observacao, Veiculo veiculo,
	                           double hodometroOuHorimetroNoMomento, TipoCombustivel tipoCombustivel,
	                           double valorLitro, double litros) {
		super(dataHora, local, observacao, veiculo);
		this.hodometro = hodometroOuHorimetroNoMomento;
		this.tipoCombustivel = tipoCombustivel;
		this.valorLitro = valorLitro;
		this.litros = litros;
	}

	public double getHodometro() {
		return hodometro;
	}

	public void setHodometro(double hodometro) {
		this.hodometro = hodometro;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("#####$ EVENTO: ABASTECIMENTO $#####");
		System.out.println("Marcador no momento: " + hodometro);
		System.out.println("Combustível: " + tipoCombustivel);
		System.out.println("Valor do litro: R$ " + String.format("%.2f", valorLitro));
		System.out.println("Litros: " + String.format("%.2f", litros));


		System.out.println("#####$ DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();

		System.out.println();
	}
}
