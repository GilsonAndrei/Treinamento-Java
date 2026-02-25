package condutores.dao;

import condutores.contratos.IntEventos;
import condutores.models.evento.EventoManutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static condutores.util.Tabelas.EVENTOS_MANUTENCAO;

public class EventoManutencaoDao
		implements IntEventos<EventoManutencao> {

	@Override
	public void inserir(Connection conn, EventoManutencao evento)
			throws SQLException {

		String sql = "INSERT INTO " + EVENTOS_MANUTENCAO +
				" (codigo, hodometro, servicosRealizados) " +
				"VALUES (?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, evento.getCodigo());
			stmt.setDouble(2, evento.getHodometro());
			stmt.setString(3, evento.getServicosRealizados());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir Manutenção.", e);
		}
	}

	@Override
	public void atualizar(Connection conn, EventoManutencao evento)
			throws SQLException {

		String sql = "UPDATE " + EVENTOS_MANUTENCAO +
				" SET hodometro=?, servicosRealizados=? " +
				"WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setDouble(1, evento.getHodometro());
			stmt.setString(2, evento.getServicosRealizados());
			stmt.setLong(3, evento.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar Manutenção.", e);
		}
	}

	@Override
	public void excluir(Connection conn, Long codigo)
			throws SQLException {

		String sql = "DELETE FROM " + EVENTOS_MANUTENCAO +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir Manutenção.", e);
		}
	}

	@Override
	public EventoManutencao buscarPorCodigo(Connection conn, Long codigo)
			throws SQLException {

		String sql = "SELECT codigo, hodometro, servicosRealizados " +
				"FROM " + EVENTOS_MANUTENCAO +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					EventoManutencao evento =
							new EventoManutencao();

					evento.setCodigo(rs.getLong("codigo"));
					evento.setHodometro(rs.getDouble("hodometro"));
					evento.setServicosRealizados(
							rs.getString("servicosRealizados")
					);

					return evento;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar Manutenção por código.", e);
		}

		return null;
	}
}