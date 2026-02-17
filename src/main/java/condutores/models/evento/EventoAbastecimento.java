package condutores.models.evento;

import condutores.enums.TipoCombustivel;
import condutores.models.Veiculo;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class EventoAbastecimento extends Evento {
	private Double hodometro;
	private TipoCombustivel tipoCombustivel;
	private Double valorLitro;
	private Double litros;

	public EventoAbastecimento() {
	}

	public EventoAbastecimento(Date dataHora, String local, String observacao, Veiculo veiculo,
	                           Double hodometroOuHorimetroNoMomento, TipoCombustivel tipoCombustivel,
	                           Double valorLitro, Double litros) {
		super(dataHora, local, observacao, veiculo);
		this.hodometro = hodometroOuHorimetroNoMomento;
		this.tipoCombustivel = tipoCombustivel;
		this.valorLitro = valorLitro;
		this.litros = litros;
	}

	public Double getHodometro() {
		return hodometro;
	}

	public void setHodometro(Double hodometro) {
		this.hodometro = hodometro;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Double valorLitro) {
		this.valorLitro = valorLitro;
	}

	public Double getLitros() {
		return litros;
	}

	public void setLitros(Double litros) {
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
