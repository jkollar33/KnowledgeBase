package sk.kollar.knowledge.domain.attributes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("BOOLEAN")
public class BooleanAttribute extends Attribute<Boolean> {
	
	@Column(name = "BOOLEAN_VALUE")
	private Boolean value;

	protected BooleanAttribute() {
	}
	
	public BooleanAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public void setValue(Boolean value) {
		this.value = value;
	}

}
