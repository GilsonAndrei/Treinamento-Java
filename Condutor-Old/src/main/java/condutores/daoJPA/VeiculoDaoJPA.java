package condutores.daoJPA;

import condutores.models.Veiculo;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class VeiculoDaoJPA extends BaseDaoImpl<Veiculo, Long> {
	public VeiculoDaoJPA(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Veiculo> getClasse() {
		return Veiculo.class;
	}
}
