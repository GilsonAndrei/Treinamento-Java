package condutores.models.evento;

import java.util.Date;

import condutores.contratos.ExibirInformacoesDetalhe;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;
import condutores.util.Tabelas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = Tabelas.EVENTOS)
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Evento implements ExibirInformacoesDetalhe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEvento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHora;

	@Column(nullable = false, length = 150)
	private String local;

	@Column(length = 900)
	private String observacao;

	/**
	 * LAZY  --> só busca quando realmente precisar do Vaiculo
	 * EAGER --> Toda vez irá buscar o Veiculo, gerando join desnecessário
	 */

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codigoVeiculo", nullable = false)
	private Veiculo veiculo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
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
		return codigoEvento;
	}

	public void setCodigo(Long codigo) {
		this.codigoEvento = codigo;
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