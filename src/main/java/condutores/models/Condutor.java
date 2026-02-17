package condutores.models;

import java.util.Date;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Condutor {

	private Long codigo;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String numeroCNH;
	private String categoriaCNH;
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
