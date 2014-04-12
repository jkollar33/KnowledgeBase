package sk.kollar.knowledge.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.FactType;
import sk.kollar.knowledge.domain.attributetypes.TextAttributeType;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
		ITestService testService = context.getBean(ITestService.class);
		
		testService.test();
		
		FactType factType = new FactType("TEST", "Test fact type", "desc");
		AttributeType attributeType = new TextAttributeType("CODE", "code attribute", "desc", true, false, false, 0);
		
		factType.addAttributeType(attributeType);

		testService.insertFactType(factType);
	}

}
