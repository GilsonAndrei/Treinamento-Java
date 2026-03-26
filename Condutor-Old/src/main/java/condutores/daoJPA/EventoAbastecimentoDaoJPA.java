package condutores.daoJPA;

import condutores.models.evento.EventoAbastecimento;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoAbastecimentoDaoJPA extends BaseDaoImpl<EventoAbastecimento, Long> {

	public EventoAbastecimentoDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EventoAbastecimento> getClasse() {
		return EventoAbastecimento.class;
	}
}
