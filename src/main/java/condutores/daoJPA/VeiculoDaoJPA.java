package condutores.daoJPA;

import condutores.models.Veiculo;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class VeiculoDaoJPA extends BaseDaoImpl<Veiculo, Long> {
	public VeiculoDaoJPA(EntityManager em, Class<Veiculo> classe) {
		super(em, classe);
	}
}
