package sk.kollar.knowledge.domain.attributes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleAttribute extends Attribute<Double> {
	
	@Column(name = "DOUBLE_VALUE")
	private Double value;

	protected DoubleAttribute() {
	}
	
	public DoubleAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}

}
