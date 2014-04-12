package sk.kollar.knowledge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sk.kollar.knowledge.dao.AttributeTypeDao;
import sk.kollar.knowledge.dao.FactTypeDao;
import sk.kollar.knowledge.domain.FactType;

@Transactional
public class TestService implements ITestService {

	private AttributeTypeDao attributeTypeDao;
	private FactTypeDao factTypeDao;

	@Autowired
	public void setAttributeTypeDao(AttributeTypeDao attributeTypeDao) {
		this.attributeTypeDao = attributeTypeDao;
	}

	@Autowired
	public void setFactTypeDao(FactTypeDao factTypeDao) {
		this.factTypeDao = factTypeDao;
	}

	@Override
	public void test() {
		System.out.println("test()");
		System.out.println(attributeTypeDao);
	}

	@Override
	public void insertFactType(FactType factType) {
		System.out.println(factType);
		FactType factType2 = factTypeDao.persist(factType);	
		System.out.println(factType2);
		FactType factType3 = factTypeDao.find(factType2.getId());
		System.out.println(factType3);
		
//		throw new RuntimeException("test should not commit");
	}

}
