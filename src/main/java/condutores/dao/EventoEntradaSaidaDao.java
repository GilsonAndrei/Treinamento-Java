package condutores.dao;

import condutores.contratos.IntEventos;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.evento.Evento;
import condutores.models.evento.EventoEntradaSaida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static condutores.util.Tabelas.*;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class EventoEntradaSaidaDao
		implements IntEventos<EventoEntradaSaida> {

	@Override
	public void inserir(Connection conn, EventoEntradaSaida evento)
			throws SQLException {

		EventoDao eventoDao = new EventoDao();
		eventoDao.inserir(conn, evento);

		// Agora o código já foi gerado
		Long codigoGerado = evento.getCodigo();

		String sql = "INSERT INTO " + EVENTOS_ENTRADA_SAIDA +
				" (codigo, tipoMovimento, codigoCondutor) " +
				"VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigoGerado);
			stmt.setString(2, evento.getTipoMovimento().name());
			stmt.setLong(3, evento.getCondutor().getCodigo());

			System.out.println(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir Evento entrada Saida: ", e);
		}
	}

	@Override
	public void atualizar(Connection conn, EventoEntradaSaida evento)
			throws SQLException {

		String sql = "UPDATE " + EVENTOS_ENTRADA_SAIDA +
				" SET tipoMovimento=?, codigoCondutor=? " +
				"WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, evento.getTipoMovimento().name());
			stmt.setLong(2, evento.getCondutor().getCodigo());
			stmt.setLong(3, evento.getCodigo());

			stmt.executeUpdate();
		}
	}

	@Override
	public void excluir(Connection conn, Long codigo)
			throws SQLException {

		String sql = "DELETE FROM " + EVENTOS_ENTRADA_SAIDA +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		}
	}

	@Override
	public EventoEntradaSaida buscarPorCodigo(Connection conn, Long codigo) throws SQLException {

		// 1️⃣ Buscar dados base
		EventoDao eventoDao = new EventoDao();
		Evento eventoBase = eventoDao.buscarPorCodigo(conn, codigo);

		if (eventoBase == null) {
			return null;
		}

		EventoEntradaSaida evento = new EventoEntradaSaida();

		// Copiar dados da base
		evento.setCodigo(eventoBase.getCodigo());
		evento.setDataHora(eventoBase.getDataHora());
		evento.setLocal(eventoBase.getLocal());
		evento.setObservacao(eventoBase.getObservacao());
		evento.setVeiculo(eventoBase.getVeiculo());
		evento.setTipoEvento(eventoBase.getTipoEvento());

		// 2️⃣ Buscar dados específicos
		String sql = "SELECT tipoMovimento, codigoCondutor FROM " + EVENTOS_ENTRADA_SAIDA + " WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					evento.setTipoMovimento(
							TipoMovimento.valueOf(rs.getString("tipoMovimento"))
					);

					Long codigoCondutor = rs.getLong("codigoCondutor");

					CondutorDao condutorDao = new CondutorDao();
					Condutor condutor =
							condutorDao.buscarPorCodigo(codigoCondutor);

					evento.setCondutor(condutor);
				}
			}
		}
		System.out.println("############################TESTE #####################");
		System.out.println(evento);
		return evento;
	}
}