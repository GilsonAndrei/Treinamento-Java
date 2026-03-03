package condutores.daoJPA;

import java.util.List;

import condutores.contratos.IntBaseDao;
import jakarta.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public class BaseDaoImpl<T, ID> implements IntBaseDao<T, ID> {

	protected EntityManager em;
	private Class<T> classe;

	public BaseDaoImpl(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}

	@Override
	public void salvar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@Override
	public T buscarPorId(ID id) {
		return em.find(classe, id);
	}

	@Override
	public void atualizar(T entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}

	@Override
	public void deletar(T entidade) {
		em.getTransaction().begin();
		em.remove(em.contains(entidade));
		em.getTransaction().commit();
	}

	@Override
	public List<T> listarTodos() {
		return em.createQuery(
				"SELECT e FROM " + classe.getSimpleName() + " e",
				classe
		).getResultList();
	}
}
