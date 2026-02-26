package condutores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import condutores.contratos.IntEventos;
import condutores.enums.TipoCombustivel;
import condutores.models.evento.EventoAbastecimento;

import static condutores.util.Tabelas.*;


/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoAbastecimentoDao implements IntEventos<EventoAbastecimento> {


	@Override
	public void inserir(Connection conn, EventoAbastecimento evento) throws SQLException {

		EventoDao eventoDao = new EventoDao();
		eventoDao.inserir(conn, evento);
		//Código geradoo.
		Long codigoGerado = evento.getCodigo();

		String sql = "INSERT INTO " + EVENTOS_ABASTECIMENTO +
				" (codigo, hodometro, tipoCombustivel, valorLitro, litros) " +
				"VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigoGerado);
			stmt.setDouble(2, evento.getHodometro());
			stmt.setString(3, evento.getTipoCombustivel().name());
			stmt.setDouble(4, evento.getValorLitro());
			stmt.setDouble(5, evento.getLitros());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir evento abastecimento.", e);
		}
	}

	@Override
	public void atualizar(Connection conn, EventoAbastecimento evento) throws SQLException {
		String sql = "UPDATE " + EVENTOS_ABASTECIMENTO +
				" SET hodometro=?, tipoCombustivel=?, valorLitro=?, litros=? " +
				"WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setDouble(1, evento.getHodometro());
			stmt.setString(2, evento.getTipoCombustivel().name());
			stmt.setDouble(3, evento.getValorLitro());
			stmt.setDouble(4, evento.getLitros());
			stmt.setLong(5, evento.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar evento abastecimento.", e);
		}
	}

	@Override
	public void excluir(Connection conn, Long codigo) throws SQLException {
		String sql = "DELETE FROM " + EVENTOS_ABASTECIMENTO +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir evento abastecimento.", e);
		}
	}

	@Override
	public EventoAbastecimento buscarPorCodigo(Connection conn, Long codigo)
			throws SQLException {

		String sql = "SELECT codigo, hodometro, tipoCombustivel, valorLitro, litros " +
				"FROM " + EVENTOS_ABASTECIMENTO +
				" WHERE codigo = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet resultado = stmt.executeQuery()) {

				if (resultado.next()) {

					EventoAbastecimento evento = new EventoAbastecimento();

					evento.setCodigo(resultado.getLong("codigo"));
					evento.setHodometro(resultado.getDouble("hodometro"));
					evento.setTipoCombustivel(
							TipoCombustivel.valueOf(
									resultado.getString("tipoCombustivel")
							)
					);
					evento.setValorLitro(resultado.getDouble("valorLitro"));
					evento.setLitros(resultado.getDouble("litros"));

					return evento;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar abastecimento por código.", e);
		}

		return null; // caso não encontre
	}


}
