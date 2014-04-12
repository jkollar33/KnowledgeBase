package sk.kollar.knowledge.domain.attributetypes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.BooleanAttribute;

@Entity
@DiscriminatorValue("BOOLEAN")
public class BooleanAttributeType extends AttributeType {
	
	public BooleanAttributeType() {
	}

	public BooleanAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence, int index) {
		super(code, name, description, mandatory, isValue, multipleOccurence, index);
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new BooleanAttribute(this);
	}

}
