package condutores.daoJPA;

import condutores.models.evento.EventoEntradaSaida;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoEntradaSaidaDaoJPA
		extends BaseDaoImpl<EventoEntradaSaida, Long> {

	@Override
	protected Class<EventoEntradaSaida> getClasse() {
		return EventoEntradaSaida.class;
	}

	public EventoEntradaSaidaDaoJPA(EntityManager em) {
		super(em);
	}
}