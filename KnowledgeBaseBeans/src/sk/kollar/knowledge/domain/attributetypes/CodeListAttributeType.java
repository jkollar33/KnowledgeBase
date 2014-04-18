package sk.kollar.knowledge.domain.attributetypes;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

public class CodeListAttributeType extends AttributeType {

	public CodeListAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence) {
		super(code, name, description, mandatory, isValue, multipleOccurence);

		// TODO
		throw new RuntimeException("not implemented!");
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented!");
	}

}
