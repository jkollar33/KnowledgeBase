package sk.kollar.knowledge.domain.attributes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("DECIMAL")
public class BigDecimalAttribute extends Attribute<BigDecimal> {
	
	@Column(name = "DECIMAL_VALUE")
	private BigDecimal value;
	
	protected BigDecimalAttribute() {
	}
	
	public BigDecimalAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value = value;
		setComputableValue(value);
	}

}
