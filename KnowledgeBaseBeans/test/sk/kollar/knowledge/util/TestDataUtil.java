package sk.kollar.knowledge.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

@Test
public class TestDataUtil {

	public void prepareTestData() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-test-context.xml");
		ITestDataPreparer testDataPreparer = context.getBean(ITestDataPreparer.class);
		testDataPreparer.prepareTestData();
	}

}
