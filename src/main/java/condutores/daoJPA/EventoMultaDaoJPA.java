package condutores.daoJPA;

import condutores.models.evento.EventoMulta;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoMultaDaoJPA extends BaseDaoImpl<EventoMulta, Long> {
	public EventoMultaDaoJPA(EntityManager em, Class<EventoMulta> classe) {
		super(em, classe);
	}
}
