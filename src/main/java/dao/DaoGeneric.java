package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.geEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(entidade);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			transaction.commit();
		}
	}
	
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();

			transaction.begin();
			E entidadeSalva = entityManager.merge(entidade);
			transaction.commit();
			
			return entidadeSalva;
	}

	public E pesquisar(E entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		E e = (E) entityManager.find(entidade.getClass(), id);

		return e;
	}

	public E pesquisar(Long id, Class<E> entidade) {

		E e = (E) entityManager.find(entidade, id);

		return e;
	}
}
