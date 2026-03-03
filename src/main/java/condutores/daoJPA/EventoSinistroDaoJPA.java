package condutores.daoJPA;

import condutores.models.evento.EventoSinistro;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class EventoSinistroDaoJPA extends BaseDaoImpl<EventoSinistro, Long> {
	public EventoSinistroDaoJPA(EntityManager em, Class<EventoSinistro> classe) {
		super(em, classe);
	}
}
