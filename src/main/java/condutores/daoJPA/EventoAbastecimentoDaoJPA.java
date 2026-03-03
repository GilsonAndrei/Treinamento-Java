package condutores.daoJPA;

import condutores.models.evento.EventoAbastecimento;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoAbastecimentoDaoJPA extends BaseDaoImpl<EventoAbastecimento, Long> {

	public EventoAbastecimentoDaoJPA(EntityManager em, Class<EventoAbastecimento> classe) {
		super(em, classe);
	}

}
