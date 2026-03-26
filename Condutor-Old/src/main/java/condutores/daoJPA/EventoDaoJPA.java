package condutores.daoJPA;

import condutores.models.evento.Evento;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoDaoJPA extends BaseDaoImpl<Evento, Long> {
	public EventoDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Evento> getClasse() {
		return Evento.class;
	}
}
