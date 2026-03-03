package condutores.models;

import java.util.Date;

import condutores.util.Tabelas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
@Entity()
@Table(name = Tabelas.CONDUTORES)

public class Condutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "cpf", nullable = false, unique = true, length = 14)
	private String cpf;
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	@Temporal(TemporalType.DATE)
	/** Temporarl é obrigatório quando usa java.util.Date, para o JPA saber se é Data, TIme, TIMESTAMP*/
	@Column(name = "dataNascimento")
	private Date dataNascimento;
	@Column(name = "NumeroCNH", length = 20, unique = true)
	private String numeroCNH;
	@Column(name = "categoriaCNH", length = 5)
	private String categoriaCNH;
	/**
	 * Temporarl é obrigatório quando usa java.util.Date, para o JPA saber se é Data, TIme, TIMESTAMP
	 */
	@Column(name = "dataVencimento")
	private Date dataVencimento;

	public Condutor() {

	}

	public Condutor(Long codigo, String cpf, String nome, Date dataNascimento, String numeroCNH, String categoriaCNH, Date dataVencimento) {
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numeroCNH = numeroCNH;
		this.categoriaCNH = categoriaCNH;
		this.dataVencimento = dataVencimento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public String getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public void exibirDetalhes() {
		System.out.println("#####$ CONDUTOR $#####");
		System.out.println("Código: " + codigo);
		System.out.println("CPF: " + cpf);
		System.out.println("Nome: " + nome);
		System.out.println("Nascimento: " + dataNascimento);
		System.out.println("CNH: " + numeroCNH + " | Categoria: " + categoriaCNH);
		System.out.println("Vencimento CNH: " + dataVencimento);
		System.out.println();
	}
}
