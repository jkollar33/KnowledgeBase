package sk.kollar.knowledge.persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.Fact;
import sk.kollar.knowledge.domain.FactType;

public class HibernateTest {
	
	private static final String FACT_TYPE_CODE = "TEST_FACT";
	private static final String FACT_CODE_ATTRIBUTE = "FACT_CODE";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
			.configure("/META-INF/hibernate.cfg.xml")
			.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
//		FactType factType = new FactType(FACT_TYPE_CODE, "Test fact type", "desc");
//		AttributeType codeAttributeType = new TextAttributeType(FACT_CODE_ATTRIBUTE, "fact code", "fact code", true, false, false, 0);
//		AttributeType numberAttributeType = new IntegerAttributeType("NUMBER", "number attribute", "desc", true, true, false, 1);
//		
//		factType.addAttributeType(codeAttributeType);
//		factType.addAttributeType(numberAttributeType);
//		
//		session.persist(factType);
		
		
		
		Criteria criteria = session.createCriteria(FactType.class);
		criteria.createAlias("attributeTypes", "attributeTypes", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("code", FACT_TYPE_CODE));
		FactType factType = (FactType) criteria.uniqueResult();
		
		tx.commit();
		session.close();

		for (AttributeType attributeType: factType.getAttributeTypes()) {
			System.out.println(attributeType.getCode() + " " + attributeType.getDescription());
		}
		
		Fact fact = factType.createFact("test1", "test1 desc");
		
		for (Attribute<?> attribute: fact.getAttributes()) {
			System.out.println(attribute.getAttributeType().getCode() + " = " + attribute.getValue());
		}
//		session.delete(factType);
		
	}

}
