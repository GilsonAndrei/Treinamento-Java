import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import condutores.enums.TipoCombustivel;
import condutores.enums.TipoControle;
import condutores.enums.TipoEvento;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.models.evento.EventoSinistro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main_JPA {

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
		EntityManager teste = emf.createEntityManager();
		EntityManager teste1 = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Veiculo veiculo = new Veiculo(
					(Long) null,
					sdf.parse("2026-01-01"),
					2020,
					"123-QER",
					"ONIX",
					TipoControle.QUILOMETROS,
					4568.0
			);

			em.persist(veiculo);

			Condutor condutor = new Condutor(null, "1234567890", "CONDUTOR TESTE", sdf.parse("2026-01-01"), "123456", "AB", sdf.parse("2026-01-01"));

			em.persist(condutor);

			EventoSinistro sinistro = new EventoSinistro(
					new Date(),
					"Curitiba",
					"Colisão",
					veiculo,
					condutor,
					false,
					true,
					"Sem danos graves",
					TipoEvento.SINISTRO
			);

			em.persist(sinistro);

			em.getTransaction().commit();

			System.out.println("Eventor salvo com sucesso!");

			//Alterar
			em.find(EventoSinistro.class, 1);

			String jpql = "SELECT e FROM EventoSinistro e";

			TypedQuery<EventoSinistro> query =
					em.createQuery(jpql, EventoSinistro.class);

			query.setMaxResults(12);

			List<EventoSinistro> lista = query.getResultList();


			System.out.println("\n🔎 Eventos encontrados:");
			for (EventoSinistro e : lista) {
				System.out.println("ID: " + e.getCodigo());
				System.out.println("Local: " + e.getLocal());
				System.out.println("Condutor: " + e.getCondutor().getNome());
				System.out.println("-------------------------");


			}

		} finally {
			em.close();
			emf.close();
		}
	}
}