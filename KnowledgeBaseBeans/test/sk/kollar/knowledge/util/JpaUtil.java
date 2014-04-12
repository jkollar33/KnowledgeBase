package sk.kollar.knowledge.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf;
	
	public static synchronized EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("KnowledgeBaseBeans");
		}
		return emf;
	}

}
