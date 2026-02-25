package condutores.models.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.EVENTOS_MULTA;
import static condutores.util.Tabelas.EVENTOS_SINISTRO;
import condutores.enums.TipoEvento;
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

	public EventoSinistro() {

	}

	public EventoSinistro(Long codigo, Date dataHora, String local, String observacao, Veiculo veiculo, Condutor condutor, boolean houveVitimas, boolean houveEnvolvidos, String laudo, TipoEvento tipoEvento) {
		super(codigo, dataHora, local, observacao, veiculo, tipoEvento);
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
/**
 @Override public void inserirEvento(Connection conn, Long codigo) {
 String sql = "INSERT INTO " + EVENTOS_SINISTRO + " (codigo,codigoCondutor,houveVitimas,houveEnvolvidos, laudo)" +
 "VALUES(?,?,?,?,?)";
 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
 stmt.setLong(1, codigo);
 stmt.setLong(2, this.getCondutor().getCodigo());
 stmt.setBoolean(3, this.isHouveVitimas());
 stmt.setBoolean(4, this.isHouveEnvolvidos());
 stmt.setString(5, this.getLaudo());
 stmt.executeUpdate();
 } catch (SQLException e) {
 throw new RuntimeException(e);
 }
 }

 @Override public void atualizarEvento(Connection conn, Long id) throws SQLException {

 }

 @Override public void excluirEvento(Connection conn, Long id) throws SQLException {

 } **/
}
