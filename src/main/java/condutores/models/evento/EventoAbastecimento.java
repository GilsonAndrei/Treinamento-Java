package condutores.models.evento;

import condutores.enums.TipoCombustivel;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;

import condutores.util.Tabelas;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = Tabelas.EVENTOS_ABASTECIMENTO)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoAbastecimento extends Evento {

	@Column(nullable = false)
	private Double hodometro;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoCombustivel tipoCombustivel;

	@Column(nullable = false)
	private Double valorLitro;

	@Column(nullable = false)
	private Double litros;

	public EventoAbastecimento() {
	}

	public EventoAbastecimento(Date dataHora, String local, String observacao,
	                           Veiculo veiculo,
	                           Double hodometro,
	                           TipoCombustivel tipoCombustivel,
	                           Double valorLitro,
	                           Double litros,
	                           TipoEvento tipoEvento) {

		super(null, dataHora, local, observacao, veiculo, tipoEvento);
		this.hodometro = hodometro;
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