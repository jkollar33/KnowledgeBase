package sk.kollar.knowledge.domain.attributes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("INTEGER")
public class IntegerAttribute extends Attribute<Integer> {
	
	@Column(name = "INTEGER_VALUE")
	private Integer value;

	protected IntegerAttribute() {
	}
	
	public IntegerAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}

}
