import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import condutores.daoJPA.CondutorDaoJPA;
import condutores.daoJPA.EventoDaoJPA;
import condutores.daoJPA.EventoEntradaSaidaDaoJPA;
import condutores.daoJPA.VeiculoDaoJPA;
import condutores.enums.TipoControle;
import condutores.enums.TipoEvento;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.models.evento.Evento;
import condutores.models.evento.EventoEntradaSaida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Main_JPA_DAO {
	public static void main(String[] args) throws IOException, ParseException {
		//Converter Data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//properties dados do banco
		Properties props = new Properties();
		props.load(Main_JPA.class
				.getClassLoader()
				.getResourceAsStream("conexao_condutores.properties"));

		Map<String, Object> config = new HashMap<>();
		config.put("jakarta.persistence.jdbc.url", props.getProperty("banco.url"));
		config.put("jakarta.persistence.jdbc.user", props.getProperty("banco.usuario"));
		config.put("jakarta.persistence.jdbc.password", props.getProperty("banco.password"));
		config.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Treinamento", config);
		EntityManager em = emf.createEntityManager();
		//########################################### Veiculo ###########################################
		Veiculo veiculo = new Veiculo((Long) null, sdf.parse("2026-01-01"), 2020, "123-QER", "ONIX", TipoControle.QUILOMETROS, 4568.0);
		VeiculoDaoJPA veiculoDao = new VeiculoDaoJPA(em);

		Veiculo veiculoId = veiculoDao.buscarPorId(1L);

		if (!veiculoId.getCodigo().equals(1L))
			veiculoDao.salvar(veiculo);
		else {
			veiculoId.setAnoFabricacao(6666);
			veiculoDao.atualizar(veiculoId);
		}
		//########################################### Condutor ###########################################
		Condutor condutor = new Condutor(null, "1234567890", "CONDUTOR TESTE", sdf.parse("2026-01-01"), "123456", "AB", sdf.parse("2026-01-01"));
		CondutorDaoJPA condutorDao = new CondutorDaoJPA(em);

		Condutor condutorId = condutorDao.buscarPorId(1L);

		if (!condutorId.getCodigo().equals(1L))
			condutorDao.salvar(condutor);
		else {
			condutorId.setNome("NOME ALTERADO TESTE");
			condutorDao.atualizar(condutorId);
		}
		//########################################### Evento Entrada Saida ###########################################
		EventoEntradaSaida entrada = new EventoEntradaSaida(
				Date.valueOf("2026-01-01"),
				"Garagem",
				"Entrada teste",
				veiculoId,
				TipoMovimento.ENTRADA,
				condutorId,
				TipoEvento.ENTRADA
		);

		EventoEntradaSaida saida = new EventoEntradaSaida(
				Date.valueOf("2026-01-02"),
				"Rodovia BR-101",
				"Saída para viagem",
				veiculoId,
				TipoMovimento.SAIDA,
				condutorId,
				TipoEvento.SAIDA
		);

		EventoEntradaSaidaDaoJPA eventoEntrada = new EventoEntradaSaidaDaoJPA(em);
		eventoEntrada.salvar(entrada);
		eventoEntrada.salvar(saida);

		saida.setObservacao("TESTE ALTERACAO");
		eventoEntrada.atualizar(saida);

		//########################################### Lista todos Eventos ###########################################
		EventoDaoJPA eventoDao = new EventoDaoJPA(em);

		List<Evento> eventos = eventoDao.listarTodos();

		for (Evento e : eventos) {
			System.out.println(e.getCodigo());
			System.out.println(e.getCodigo());
		}
	}
}
