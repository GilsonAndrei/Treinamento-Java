package condutores.daoJPA;

import condutores.models.evento.EventoSinistro;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoSinistroDaoJPA extends BaseDaoImpl<EventoSinistro, Long> {
	public EventoSinistroDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EventoSinistro> getClasse() {
		return EventoSinistro.class;
	}
}
