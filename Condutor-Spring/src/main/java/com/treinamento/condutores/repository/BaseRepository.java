package com.treinamento.condutores.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */

@Repository
public abstract class BaseRepository<T, ID> {

	@PersistenceContext
	protected EntityManager em;

	protected abstract Class<T> getClasse();

	@Transactional //Spring é quem controla as transções
	public void salvar(T entidade) {
		//em.getTransaction().begin();
		em.persist(entidade);
		//em.getTransaction().commit();
	}

	@Transactional
	public void deletar(T entidade) {
		em.remove(entidade);
	}

	public T buscarPorId(ID id) {
		return em.find(getClasse(), id);
	}

	public List<T> listarTodos() {
		return em.createQuery(
				"SELECT e FROM " + getClasse().getSimpleName() + " e",
				getClasse()
		).getResultList();
	}

	public T buscarPorCampoString(String campo, String valor) {
		try {
			String jpql = "SELECT e FROM " + getClasse().getSimpleName() + " e WHERE e." + campo + " = :" + campo;

			return em.createQuery(jpql, getClasse())
					.setParameter(campo, valor)
					.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}
}
