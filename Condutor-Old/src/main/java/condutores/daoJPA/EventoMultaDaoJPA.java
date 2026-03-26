package condutores.daoJPA;

import condutores.models.evento.EventoMulta;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoMultaDaoJPA extends BaseDaoImpl<EventoMulta, Long> {
	public EventoMultaDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EventoMulta> getClasse() {
		return EventoMulta.class;
	}
}
