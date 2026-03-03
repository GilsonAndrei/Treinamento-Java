package condutores.daoJPA;

import condutores.models.evento.EventoManutencao;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoManutencaoDaoJPA extends BaseDaoImpl<EventoManutencao, Long> {
	public EventoManutencaoDaoJPA(EntityManager em, Class<EventoManutencao> classe) {
		super(em, classe);
	}
}
