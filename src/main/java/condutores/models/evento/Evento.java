package condutores.models.evento;

import java.util.Date;

import condutores.contratos.ExibirInformacoesDetalhe;
import condutores.models.Veiculo;

public abstract class Evento implements ExibirInformacoesDetalhe {
	private Date dataHora;
	private String local;
	private String observacao;
	private Veiculo veiculo;


	public Evento() {
	}

	public Evento(Date dataHora, String local, String observacao, Veiculo veiculo) {
		this.dataHora = dataHora;
		this.local = local;
		this.observacao = observacao;
		this.veiculo = veiculo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}