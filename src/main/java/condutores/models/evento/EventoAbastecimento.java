package condutores.models.evento;

import condutores.enums.TipoCombustivel;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static condutores.util.Tabelas.*;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class EventoAbastecimento extends Evento {
	private Long codigo;
	private Double hodometro;
	private TipoCombustivel tipoCombustivel;
	private Double valorLitro;
	private Double litros;

	public EventoAbastecimento() {

	}

	public EventoAbastecimento(Long codigo, Date dataHora, String local, String observacao, Veiculo veiculo,
	                           Double hodometroOuHorimetroNoMomento, TipoCombustivel tipoCombustivel,
	                           Double valorLitro, Double litros, TipoEvento tipoEvento) {
		super(codigo, dataHora, local, observacao, veiculo, tipoEvento);
		this.hodometro = hodometroOuHorimetroNoMomento;
		this.tipoCombustivel = tipoCombustivel;
		this.valorLitro = valorLitro;
		this.litros = litros;
	}

	@Override
	public Long getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	/**@Override public void inserirEvento(Connection conn, Long codigo) {
	String sql = "INSERT INTO " + EVENTOS_ABASTECIMENTO + " (codigo,hodometro,tipoCombustivel,valorLitro,litros)" +
	"VALUES(?,?,?,?,?)";
	try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	stmt.setLong(1, codigo);
	stmt.setDouble(2, this.getHodometro());
	stmt.setString(3, this.getTipoCombustivel().name());
	stmt.setDouble(4, this.getValorLitro());
	stmt.setDouble(5, this.getLitros());
	stmt.executeUpdate();
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
	}

	 @Override public void atualizarEvento(Connection conn, Long id) throws SQLException {

	 String sql = "UPDATE " + EVENTOS_ABASTECIMENTO +
	 " SET hodometro=?, tipoCombustivel=?, valorLitro=?, litros=? " +
	 "WHERE codigo=?";

	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	 stmt.setDouble(1, this.getHodometro());
	 stmt.setString(2, this.getTipoCombustivel().name());
	 stmt.setDouble(3, this.getValorLitro());
	 stmt.setDouble(4, this.getLitros());
	 stmt.setLong(5, id);

	 stmt.executeUpdate();
	 }
	 }

	 //@Override
	 public void excluirEvento(Connection conn, Long id) throws SQLException {

	 String sql = "DELETE FROM " + EVENTOS_ABASTECIMENTO +
	 " WHERE codigo=?";

	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	 stmt.setLong(1, id);
	 stmt.executeUpdate();
	 }
	 }

	 */
}
