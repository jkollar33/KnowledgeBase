package sk.kollar.knowledge.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sk.kollar.knowledge.dao.impl.jpa.FactTypeDaoJpa;
import sk.kollar.knowledge.util.JpaUtil;

@Test
public class FactTypeDaoTest {
	
	private EntityManager em;
	private FactTypeDaoJpa factTypeDao;

	@BeforeClass
	public void setup() {
		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		em = emf.createEntityManager(); // Retrieve an application managed entity manager
		factTypeDao = new FactTypeDaoJpa();
		factTypeDao.setEntityManager(em);
	}

	@AfterClass
	public void cleanup() {
		em.close();
	}
	
	public void testFind() {
		factTypeDao.find(1l);
	}
}
