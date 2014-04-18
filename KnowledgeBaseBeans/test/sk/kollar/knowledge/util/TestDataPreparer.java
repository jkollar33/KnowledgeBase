package sk.kollar.knowledge.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.FactType;
import sk.kollar.knowledge.domain.attributetypes.IntegerAttributeType;
import sk.kollar.knowledge.domain.attributetypes.TextAttributeType;

@Repository
@Transactional
public class TestDataPreparer implements ITestDataPreparer {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void prepareTestData() {
		createFactTypes();
	}

	private void createFactTypes() {
		FactType testFactType = new FactType("TEST", "Test", "Test fact");
		AttributeType att1 = new TextAttributeType("NAME", "Name", "Name of fact", true, false, false);
		AttributeType att2 = new IntegerAttributeType("NUMBER", "Number", "Number", true, true, false);
		
		testFactType.addAttributeType(att1);
		testFactType.addAttributeType(att2);
		
		entityManager.persist(testFactType);
		
		testFactType.removeAttributeType(att1);
		testFactType.addAttributeType(att1);
		
		entityManager.merge(testFactType);
	}

}
