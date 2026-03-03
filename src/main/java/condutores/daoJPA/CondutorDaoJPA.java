package condutores.daoJPA;

import condutores.models.Condutor;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CondutorDaoJPA extends BaseDaoImpl<Condutor, Long> {

	public CondutorDaoJPA(EntityManager em, Class<Condutor> classe) {
		super(em, classe);
	}
}
