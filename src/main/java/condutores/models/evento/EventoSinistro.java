package condutores.models.evento;

import java.util.Date;

import condutores.models.Condutor;
import condutores.models.Veiculo;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoSinistro extends Evento {
	private Condutor condutor;
	private boolean houveVitimas;
	private boolean houveEnvolvidos;
	private String laudo;

	public EventoSinistro(Date dataHora, String local, String observacao, Veiculo veiculo, Condutor condutor, boolean houveVitimas, boolean houveEnvolvidos, String laudo) {
		super(dataHora, local, observacao, veiculo);
		this.condutor = condutor;
		this.houveVitimas = houveVitimas;
		this.houveEnvolvidos = houveEnvolvidos;
		this.laudo = laudo;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public boolean isHouveVitimas() {
		return houveVitimas;
	}

	public void setHouveVitimas(boolean houveVitimas) {
		this.houveVitimas = houveVitimas;
	}

	public boolean isHouveEnvolvidos() {
		return houveEnvolvidos;
	}

	public void setHouveOutrosEnvolvidos(boolean houveEnvolvidos) {
		this.houveEnvolvidos = houveEnvolvidos;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("#####$ EVENTO: SINISTRO $#####");
		System.out.println("Condutor: " + condutor.getNome());
		System.out.println("Houve vítimas? " + (houveVitimas ? "Sim" : "Não"));
		System.out.println("Houve envolvidos? " + (houveEnvolvidos ? "Sim" : "Não"));
		System.out.println("Laudo: " + laudo);
		System.out.println();

		System.out.println("#####$ EVENTO SINISTRO -SAIDA : DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}
