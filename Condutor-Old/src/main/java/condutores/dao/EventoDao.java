package condutores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import condutores.contratos.IntEventos;
import condutores.enums.TipoEvento;
import condutores.models.Veiculo;
import condutores.models.evento.Evento;
import static condutores.util.Tabelas.*;
import condutores.models.evento.EventoAbastecimento;
import condutores.models.evento.EventoEntradaSaida;
import condutores.models.evento.EventoManutencao;
import condutores.models.evento.EventoMulta;
import condutores.models.evento.EventoSinistro;
import condutores.util.Conexao;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoDao implements IntEventos<Evento> {

	@Override
	public void inserir(Connection conn, Evento evento) throws SQLException {

		String sql = "INSERT INTO " + EVENTOS +
				" (dataHora, local, observacao, codigoVeiculo, tipoEvento) " +
				"VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setTimestamp(1, new java.sql.Timestamp(evento.getDataHora().getTime()));
			stmt.setString(2, evento.getLocal());
			stmt.setString(3, evento.getObservacao());
			stmt.setLong(4, evento.getVeiculo().getCodigo());
			stmt.setString(5, evento.getTipoEvento().name());

			stmt.executeUpdate();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					evento.setCodigo(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir Evento.", e);
		}
	}

	@Override
	public void atualizar(Connection conn, Evento evento) throws SQLException {

		String sql = "UPDATE " + EVENTOS +
				" SET dataHora=?, local=?, observacao=?, codigoVeiculo=?, tipo_evento=? " +
				"WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setTimestamp(1, new java.sql.Timestamp(evento.getDataHora().getTime()));
			stmt.setString(2, evento.getLocal());
			stmt.setString(3, evento.getObservacao());
			stmt.setLong(4, evento.getVeiculo().getCodigo());
			stmt.setString(5, evento.getTipoEvento().name());
			stmt.setLong(6, evento.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar Evento .", e);
		}
	}

	@Override
	public void excluir(Connection conn, Long codigo) throws SQLException {

		String sql = "DELETE FROM " + EVENTOS +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir Evento.", e);
		}
	}

	@Override
	public Evento buscarPorCodigo(Connection conn, Long codigo) throws SQLException {

		String sql = "SELECT codigo, dataHora, local, observacao, codigoVeiculo, tipoEvento " +
				"FROM " + EVENTOS +
				" WHERE codigo=?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, codigo);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					String tipo = rs.getString("tipoEvento");

					Evento evento;

					switch (TipoEvento.valueOf(tipo)) {

						case ABASTECIMENTO:
							evento = new EventoAbastecimento();
							break;

						case MANUTENCAO:
							evento = new EventoManutencao();
							break;

						case ENTRADA:
							evento = new EventoEntradaSaida();
							break;
						case SAIDA:
							evento = new EventoEntradaSaida();
							break;
						case MULTA:
							evento = new EventoMulta();
							break;
						case SINISTRO:
							evento = new EventoSinistro();
							break;

						default:
							throw new IllegalArgumentException("Tipo de evento inválido");
					}

					evento.setCodigo(rs.getLong("codigo"));
					evento.setDataHora(rs.getTimestamp("dataHora"));
					evento.setLocal(rs.getString("local"));
					evento.setObservacao(rs.getString("observacao"));

					Veiculo veiculo = new Veiculo();
					veiculo.setCodigo(rs.getLong("codigoVeiculo"));
					evento.setVeiculo(veiculo);

					evento.setTipoEvento(TipoEvento.valueOf(tipo));

					return evento;
				}
			}
		}

		return null;
	}

	public List<Evento> listarTodos(Connection conn) throws SQLException {

		String sql = "SELECT codigo, dataHora, local, observacao, codigoVeiculo, tipoEvento FROM " + EVENTOS;

		List<Evento> lista = new ArrayList<>();

		try (PreparedStatement stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {

				Long codigo = rs.getLong("codigo");
				TipoEvento tipo = TipoEvento.valueOf(rs.getString("tipoEvento"));

				Evento evento;

				switch (tipo) {

					case ENTRADA:
						EventoEntradaSaidaDao esDaoEnt = new EventoEntradaSaidaDao();
						evento = esDaoEnt.buscarPorCodigo(conn, codigo);
						break;

					case SAIDA:
						EventoEntradaSaidaDao esDaoSai = new EventoEntradaSaidaDao();
						evento = esDaoSai.buscarPorCodigo(conn, codigo);
						break;

					case ABASTECIMENTO:
						EventoAbastecimentoDao abDao = new EventoAbastecimentoDao();
						evento = abDao.buscarPorCodigo(conn, codigo);
						break;

					case MANUTENCAO:
						EventoManutencaoDao mDao = new EventoManutencaoDao();
						evento = mDao.buscarPorCodigo(conn, codigo);
						break;

					case MULTA:
						EventoMultaDao multaDao = new EventoMultaDao();
						evento = multaDao.buscarPorCodigo(conn, codigo);
						break;

					case SINISTRO:
						EventoSinistroDao sDao = new EventoSinistroDao();
						evento = sDao.buscarPorCodigo(conn, codigo);
						break;

					default:
						throw new IllegalArgumentException("Tipo inválido");
				}

				lista.add(evento);
			}
		}

		return lista;
	}

}