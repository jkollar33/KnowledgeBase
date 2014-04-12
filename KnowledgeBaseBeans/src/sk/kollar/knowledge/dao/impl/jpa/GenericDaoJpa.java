package sk.kollar.knowledge.dao.impl.jpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sk.kollar.knowledge.dao.GenericDao;

@Repository
public class GenericDaoJpa<T> 
implements GenericDao<T, Long> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoJpa() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T persist(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public T find(Long id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		t = entityManager.merge(t);
		entityManager.remove(t);
	}
}