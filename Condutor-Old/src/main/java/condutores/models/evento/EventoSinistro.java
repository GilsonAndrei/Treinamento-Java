package condutores.models.evento;

import java.util.Date;

import condutores.enums.TipoEvento;
import condutores.models.Condutor;
import condutores.models.Veiculo;

import condutores.util.Tabelas;

import javax.persistence.*;

@Entity
@Table(name = Tabelas.EVENTOS_SINISTRO)
@PrimaryKeyJoinColumn(name = "codigoEvento")

public class EventoSinistro extends Evento {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoCondutor", nullable = false)
	private Condutor condutor;

	@Column(nullable = false)
	private boolean houveVitimas;

	@Column(nullable = false)
	private boolean houveEnvolvidos;

	@Column(length = 1000)
	private String laudo;

	public EventoSinistro() {
	}

	public EventoSinistro(Date dataHora,
	                      String local,
	                      String observacao,
	                      Veiculo veiculo,
	                      Condutor condutor,
	                      boolean houveVitimas,
	                      boolean houveEnvolvidos,
	                      String laudo,
	                      TipoEvento tipoEvento) {

		super(null, dataHora, local, observacao, veiculo, tipoEvento);
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

	public void setHouveEnvolvidos(boolean houveEnvolvidos) {
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

		System.out.println("#####$ DADOS DO VEICULO $#####");
		getVeiculo().exibirDetalhes();
		System.out.println();
	}
}