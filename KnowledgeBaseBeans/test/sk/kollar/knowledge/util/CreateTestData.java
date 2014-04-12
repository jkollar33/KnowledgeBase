package sk.kollar.knowledge.util;

import javax.persistence.EntityManagerFactory;

import org.testng.annotations.Test;

import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.FactType;
import sk.kollar.knowledge.domain.attributetypes.IntegerAttributeType;
import sk.kollar.knowledge.domain.attributetypes.TextAttributeType;

@Test
public class CreateTestData {
	
	public void run() {
		EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
		FactType testFactType = new FactType("TEST", "Test", "Test fact");
		AttributeType att1 = new TextAttributeType("A1", "Name", "Name of fact", true, false, false, 0);
		AttributeType att2 = new IntegerAttributeType("A2", "Number", "Number", true, true, false, 1);
		
		testFactType.addAttributeType(att1);
		testFactType.addAttributeType(att2);
	}

}
