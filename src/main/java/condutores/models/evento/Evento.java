package condutores.models.evento;

import java.util.Date;

import condutores.contratos.ExibirInformacoesDetalhe;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;
import condutores.util.Tabelas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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