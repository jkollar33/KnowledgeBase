package sk.kollar.knowledge.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.Fact;
import sk.kollar.knowledge.domain.FactType;
import sk.kollar.knowledge.domain.Role;
import sk.kollar.knowledge.domain.User;
import sk.kollar.knowledge.domain.UserFact;
import sk.kollar.knowledge.domain.attributes.BooleanAttribute;
import sk.kollar.knowledge.domain.attributes.DateAttribute;
import sk.kollar.knowledge.domain.attributes.IntegerAttribute;
import sk.kollar.knowledge.domain.attributes.TextAttribute;
import sk.kollar.knowledge.domain.attributetypes.BooleanAttributeType;
import sk.kollar.knowledge.domain.attributetypes.DateAttributeType;
import sk.kollar.knowledge.domain.attributetypes.IntegerAttributeType;
import sk.kollar.knowledge.domain.attributetypes.TextAttributeType;

@Repository
@Transactional
public class TestDataPreparer implements ITestDataPreparer {
	
	// constants
	private static final String ATT_CODE_EXTERNAL = "EXTERNAL";
	private static final String ATT_CODE_DATE_START = "DATE_START";
	private static final String ATT_CODE_LENGTH_MD = "LENGTH_MD";
	private static final String ATT_CODE_PROJ_NAME = "PROJ_NAME";
	private static final String ATT_CODE_DATE_OBTAINED = "DATE_OBTAINED";
	private static final String ATT_CODE_CERT_NAME = "CERT_NAME";
	
	// users
	private static User user1 = null;
	private static User user2 = null;
	
	// fact types
	private static FactType projectFactType = null;
	private static FactType certificateFactType = null;
	
	// facts
	private static Fact herculesProject = null;
	private static Fact ocjpCertificate = null;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void prepareTestData() {
		createUsersAndRoles();
		createFactTypes();
		createFacts();
		joinUsersAndFacts();
	}

	private void createFactTypes() {
		projectFactType = new FactType("PROJECT", "Project", "Project");
		AttributeType nameAtt = new TextAttributeType(ATT_CODE_PROJ_NAME, "Name", "Name of fact", true, false, false);
		AttributeType lengthAtt = new IntegerAttributeType(ATT_CODE_LENGTH_MD, "Length in MD", 
				"Length of the project in mandays", true, true, false);
		AttributeType dateStartAtt = new DateAttributeType(ATT_CODE_DATE_START, "Start date", "", true, false, false);
		AttributeType externalAtt = new BooleanAttributeType(ATT_CODE_EXTERNAL, "External project", 
				"Project for external client", true, true, false);
		
		projectFactType.addAttributeType(nameAtt);
		projectFactType.addAttributeType(lengthAtt);
		projectFactType.addAttributeType(dateStartAtt);
		projectFactType.addAttributeType(externalAtt);
		
		entityManager.persist(projectFactType);

		certificateFactType = new FactType("CERTIFICATE", "Certificate", "Certificate");
		AttributeType certNameAtt = new TextAttributeType(ATT_CODE_CERT_NAME, "Name", "Name of fact", true, false, false);
		AttributeType dateObtainedAtt = new DateAttributeType(ATT_CODE_DATE_OBTAINED, "Date obtained", "", true, false, false);
		
		certificateFactType.addAttributeType(certNameAtt);
		certificateFactType.addAttributeType(dateObtainedAtt);

		entityManager.persist(certificateFactType);
	}

	private void createFacts() {
		herculesProject = projectFactType.createFact("Herkules", "Herkules project");
		herculesProject.getAttributeByCode(ATT_CODE_PROJ_NAME, TextAttribute.class).setValue("Hercules");
		herculesProject.getAttributeByCode(ATT_CODE_LENGTH_MD, IntegerAttribute.class).setValue(200);
		herculesProject.getAttributeByCode(ATT_CODE_DATE_START, DateAttribute.class).setValue(new Date());
		herculesProject.getAttributeByCode(ATT_CODE_EXTERNAL, BooleanAttribute.class).setValue(Boolean.TRUE);

		entityManager.persist(herculesProject);
		
		ocjpCertificate = certificateFactType.createFact("OCJP", "Oracle certified java programmer");
		ocjpCertificate.getAttributeByCode(ATT_CODE_CERT_NAME, TextAttribute.class)
			.setValue("Oracle certified java programmer");
		ocjpCertificate.getAttributeByCode(ATT_CODE_DATE_OBTAINED, DateAttribute.class).setValue(new Date());

		entityManager.persist(ocjpCertificate);
	}
	
	private void createUsersAndRoles() {
		Role defineFactTypesRole = new Role("DEFINE_FACT_TYPES", "Defines facts types", 
				"Role for user who can define fact types");
		Role defineFactRole = new Role("DEFINE_FACT", "Defines facts", "Role for user who can define facts");

		user1 = new User("USER1", "USER1", "John", "Doe");
		user1.addRole(defineFactRole);
		entityManager.persist(user1);
		
		user2 = new User("USER2", "USER2", "Bruce", "Lee");
		user2.addRole(defineFactRole);
		user2.addRole(defineFactTypesRole);
		
		entityManager.persist(user2);
	}
	
	private void joinUsersAndFacts() {
		UserFact user1Fact1 = new UserFact();
		user1Fact1.setUser(user1);
		user1Fact1.setFact(herculesProject);
		user1Fact1.setDateObtained(new Date());
		entityManager.persist(user1Fact1);
		
		UserFact user2Fact1 = new UserFact();
		user2Fact1.setUser(user2);
		user2Fact1.setFact(herculesProject);
		user2Fact1.setDateObtained(new Date());
		entityManager.persist(user2Fact1);
		
		UserFact user2Fact2 = new UserFact();
		user2Fact2.setUser(user2);
		user2Fact2.setFact(ocjpCertificate);
		user2Fact2.setDateObtained(new Date());
		entityManager.persist(user2Fact2);
	}

}
