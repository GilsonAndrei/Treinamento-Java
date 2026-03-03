import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import condutores.dao.CondutorDao;
import condutores.dao.EventoDao;
import condutores.dao.EventoEntradaSaidaDao;
import condutores.dao.VeiculoDao;
import condutores.enums.TipoControle;
import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.models.evento.Evento;
import condutores.models.evento.EventoEntradaSaida;
import condutores.util.Conexao;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class Main_DAO {
	public static void main(String[] args) {

		try (Connection conn = Conexao.getConexao()) {

			conn.setAutoCommit(false);

			try {
				//############################################################################################
				//Veiculo
				VeiculoDao veiculoDao = new VeiculoDao();
				Veiculo veiculo = new Veiculo(3L,
						Date.valueOf("2026-01-01"),
						2020,
						"QQQ-9988",
						"CARRO DE TESTE",
						TipoControle.QUILOMETROS,
						60000.00);
				veiculo.exibirDetalhes();

				//				veiculoDao.inserir(veiculo);

				//############################################################################################
				//Condutor
				CondutorDao condutorDao = new CondutorDao();
				Condutor condutor = new Condutor(1L, "0123456789", "Condutor 001", Date.valueOf("1994-01-01"), "5464654", "AB", Date.valueOf("2027-01-01"));
				condutor.exibirDetalhes();
				//				//condutorDao.inserir(condutor);
				//				Condutor condutorAlterar = new Condutor(1L, "39511950886", "Condutor 001", Date.valueOf("1994-01-01"), "5464654", "AB", Date.valueOf("2027-01-01"));
				//				condutorDao.atualizar(condutorAlterar);
				condutor.exibirDetalhes();

				//############################################################################################
				//Entrada/Saida
				EventoEntradaSaidaDao eventoDao = new EventoEntradaSaidaDao();

				EventoEntradaSaida entrada = new EventoEntradaSaida(
						Date.valueOf("2026-01-01"),
						"Garagem",
						"Entrada teste",
						veiculo,
						TipoMovimento.ENTRADA,
						condutor,
						TipoEvento.ENTRADA
				);

				EventoEntradaSaida saida = new EventoEntradaSaida(
						Date.valueOf("2026-01-02"),
						"Rodovia BR-101",
						"Saída para viagem",
						veiculo,
						TipoMovimento.SAIDA,
						condutor, TipoEvento.SAIDA
				);

				eventoDao.inserir(conn, entrada);
				eventoDao.inserir(conn, saida);

				//############################################################################################
				//Listagem dos eventos, Metodo listarTodos declarado no Evento para poder utilizar polimorfismo,
				// o listar todos trata o tipo e o exibir detalhes chama de acordo com o tipo
				EventoDao eventoDao1 = new EventoDao();

				List<Evento> eventos = eventoDao1.listarTodos(conn);

				for (Evento e : eventos) {
					e.exibirDetalhes();
				}

				conn.commit();
				System.out.println("Commit executado com sucesso!");
			} catch (Exception e) {

				conn.rollback();
				System.err.println("Erro! Rollback executado.");
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
