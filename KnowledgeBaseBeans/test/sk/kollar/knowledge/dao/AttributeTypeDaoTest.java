package sk.kollar.knowledge.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sk.kollar.knowledge.dao.impl.jpa.AttributeTypeDaoJpa;
import sk.kollar.knowledge.util.JpaUtil;

@Test
public class AttributeTypeDaoTest {
	
	private EntityManager em;
	private AttributeTypeDaoJpa attributeTypeDao;

	@BeforeClass
	public void setup() {
		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		em = emf.createEntityManager(); // Retrieve an application managed entity manager
		attributeTypeDao = new AttributeTypeDaoJpa();
		attributeTypeDao.setEntityManager(em);
	}

	@AfterClass
	public void cleanup() {
		em.close();
	}
	
	public void testFind() {
		attributeTypeDao.find(1l);
	}
}
