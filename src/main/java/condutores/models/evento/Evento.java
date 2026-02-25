package condutores.models.evento;

import java.util.Date;

import condutores.contratos.ExibirInformacoesDetalhe;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;

public abstract class Evento implements ExibirInformacoesDetalhe {
	private Long codigo;
	private Date dataHora;
	private String local;
	private String observacao;
	private Veiculo veiculo;
	private TipoEvento tipoEvento;


	public Evento() {
	}

	public Evento(Long codigo, Date dataHora, String local, String observacao, Veiculo veiculo, TipoEvento tipoEvento) {
		this.dataHora = dataHora;
		this.local = local;
		this.observacao = observacao;
		this.veiculo = veiculo;
		this.tipoEvento = tipoEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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