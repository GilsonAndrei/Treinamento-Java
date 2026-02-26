package condutores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import condutores.models.Condutor;
import condutores.models.evento.EventoSinistro;

import static condutores.util.Tabelas.EVENTOS_SINISTRO;

public class EventoSinistroDao {

	public void inserir(Connection conn, EventoSinistro evento) throws SQLException {

		EventoDao eventoDao = new EventoDao();
		eventoDao.inserir(conn, evento);
		//Código geradoo.
		Long codigoGerado = evento.getCodigo();

		String sql = "INSERT INTO " + EVENTOS_SINISTRO +
				" (codigo, codigoCondutor, houveVitimas, houveEnvolvidos, laudo) " +
				"VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigoGerado);
			stmt.setLong(2, evento.getCondutor().getCodigo());
			stmt.setBoolean(3, evento.isHouveVitimas());
			stmt.setBoolean(4, evento.isHouveEnvolvidos());
			stmt.setString(5, evento.getLaudo());

			stmt.executeUpdate();
		}
	}

	public void atualizar(Connection conn, EventoSinistro evento) throws SQLException {

		String sql = "UPDATE " + EVENTOS_SINISTRO +
				" SET codigoCondutor = ?, houveVitimas = ?, houveEnvolvidos = ?, laudo = ? " +
				"WHERE codigo = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, evento.getCondutor().getCodigo());
			stmt.setBoolean(2, evento.isHouveVitimas());
			stmt.setBoolean(3, evento.isHouveEnvolvidos());
			stmt.setString(4, evento.getLaudo());
			stmt.setLong(5, evento.getCodigo());

			stmt.executeUpdate();
		}
	}

	public void excluir(Connection conn, Long codigo) throws SQLException {

		String sql = "DELETE FROM " + EVENTOS_SINISTRO + " WHERE codigo = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		}
	}

	public EventoSinistro buscarPorCodigo(Connection conn, Long codigo) throws SQLException {

		String sql = "SELECT * FROM " + EVENTOS_SINISTRO + " WHERE codigo = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					EventoSinistro evento = new EventoSinistro();

					evento.setCodigo(codigo);

					// Aqui você pode depois buscar o Condutor via CondutorDao
					Condutor condutor = new Condutor();
					condutor.setCodigo(rs.getLong("codigoCondutor"));

					evento.setCondutor(condutor);
					evento.setHouveVitimas(rs.getBoolean("houveVitimas"));
					evento.setHouveOutrosEnvolvidos(rs.getBoolean("houveEnvolvidos"));
					evento.setLaudo(rs.getString("laudo"));

					return evento;
				}
			}
		}

		return null;
	}
}