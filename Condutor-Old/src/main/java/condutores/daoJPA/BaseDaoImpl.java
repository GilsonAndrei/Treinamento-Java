package condutores.daoJPA;

import java.util.List;

import condutores.contratos.IntBaseDao;

import javax.persistence.EntityManager;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

public abstract class BaseDaoImpl<T, ID> implements IntBaseDao<T, ID> {

	protected EntityManager em;

	//Cada classe filha vai informar a classe , o tipo da classe
	protected abstract Class<T> getClasse();

	public BaseDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@Override
	public T buscarPorId(ID id) {
		return em.find(getClasse(), id);
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
				"SELECT e FROM " + getClasse().getSimpleName() + " e",
				getClasse()
		).getResultList();
	}
}
