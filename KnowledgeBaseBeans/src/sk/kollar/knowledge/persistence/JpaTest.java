package sk.kollar.knowledge.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.FactType;
import sk.kollar.knowledge.domain.attributetypes.TextAttributeType;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KnowledgeBaseBeans");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		FactType factType = new FactType("TEST", "Test fact type", "desc");
		AttributeType attributeType = new TextAttributeType("CODE", "code attribute", "desc", true, false, false);
		
		factType.addAttributeType(attributeType);
		
		em.persist(factType);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<FactType> query = criteriaBuilder.createQuery(FactType.class);
		Root<FactType> root = query.from(FactType.class);
		query.where(criteriaBuilder.equal(root.get("code"), "TEST"));
		FactType factTypeDb = em.createQuery(query).getSingleResult();
		
		System.out.println(factTypeDb);
		
//		em.remove(factType);
		
		tx.commit();
		
		em.close();
		emf.close(); //close at application end
	}

}
