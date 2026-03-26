package condutores.daoJPA;

import condutores.models.evento.EventoManutencao;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoManutencaoDaoJPA extends BaseDaoImpl<EventoManutencao, Long> {
	public EventoManutencaoDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EventoManutencao> getClasse() {
		return EventoManutencao.class;
	}
}
