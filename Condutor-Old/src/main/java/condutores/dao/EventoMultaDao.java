package condutores.dao;

import condutores.contratos.IntEventos;
import condutores.enums.TipoInfracao;
import condutores.models.Condutor;
import condutores.models.evento.EventoMulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static condutores.util.Tabelas.EVENTOS_MULTA;

public class EventoMultaDao
		implements IntEventos<EventoMulta> {

	@Override
	public void inserir(Connection conn, EventoMulta evento)
			throws SQLException {

		EventoDao eventoDao = new EventoDao();
		eventoDao.inserir(conn, evento);
		//Código geradoo.
		Long codigoGerado = evento.getCodigo();

		String sql = "INSERT INTO " + EVENTOS_MULTA +
				" (codigo, codigoCondutor, tipoInfracao, pontosCnh, valorMulta) " +
				"VALUES (?, ?, ?, ?, ?) ";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigoGerado);
			stmt.setLong(2, evento.getCondutor().getCodigo());
			stmt.setString(3, evento.getTipoInfracao().name());
			stmt.setInt(4, evento.getPontosCnh());
			stmt.setDouble(5, evento.getValorMulta());

			stmt.executeUpdate();
		}
	}

	@Override
	public void atualizar(Connection conn, EventoMulta evento)
			throws SQLException {

		String sql = "UPDATE " + EVENTOS_MULTA +
				" SET codigoCondutor=?, tipoInfracao=?, pontosCnh=?, valorMulta=? " +
				"WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, evento.getCondutor().getCodigo());
			stmt.setString(2, evento.getTipoInfracao().name());
			stmt.setInt(3, evento.getPontosCnh());
			stmt.setDouble(4, evento.getValorMulta());
			stmt.setLong(5, evento.getCodigo());

			stmt.executeUpdate();
		}
	}

	@Override
	public void excluir(Connection conn, Long codigo)
			throws SQLException {

		String sql = "DELETE FROM " + EVENTOS_MULTA +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		}
	}

	@Override
	public EventoMulta buscarPorCodigo(Connection conn, Long codigo)
			throws SQLException {

		String sql = "SELECT codigo, codigoCondutor, tipoInfracao, pontosCnh, valorMulta " +
				"FROM " + EVENTOS_MULTA +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					EventoMulta evento = new EventoMulta();

					evento.setCodigo(rs.getLong("codigo"));

					Condutor condutor = new Condutor();
					condutor.setCodigo(rs.getLong("codigoCondutor"));
					evento.setCondutor(condutor);

					evento.setTipoInfracao(
							TipoInfracao.valueOf(
									rs.getString("tipoInfracao")
							)
					);
					evento.setPontosCnh(
							rs.getInt("pontosCnh")
					);
					evento.setValorMulta(
							rs.getDouble("valorMulta")
					);
					return evento;
				}
			}
		}
		return null;
	}
}