package condutores.daoJPA;

import condutores.models.evento.Evento;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoDaoJPA extends BaseDaoImpl<Evento, Long> {
	public EventoDaoJPA(EntityManager em, Class<Evento> classe) {
		super(em, classe);
	}
}
