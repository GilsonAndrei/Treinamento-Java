package condutores.daoJPA;

import condutores.models.Condutor;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class CondutorDaoJPA extends BaseDaoImpl<Condutor, Long> {

	@Override
	protected Class<Condutor> getClasse() {
		return Condutor.class;
	}

	public CondutorDaoJPA(EntityManager em) {
		super(em);
	}
}
