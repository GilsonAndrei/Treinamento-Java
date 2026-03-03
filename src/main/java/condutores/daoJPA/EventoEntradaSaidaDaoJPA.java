package condutores.daoJPA;

import condutores.models.evento.EventoEntradaSaida;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoEntradaSaidaDaoJPA
		extends BaseDaoImpl<EventoEntradaSaida, Long> {

	public EventoEntradaSaidaDaoJPA(EntityManager em) {
		super(em, EventoEntradaSaida.class);
	}
}