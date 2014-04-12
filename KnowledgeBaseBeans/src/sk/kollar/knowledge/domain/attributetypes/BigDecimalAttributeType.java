package sk.kollar.knowledge.domain.attributetypes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.BigDecimalAttribute;

@Entity
@DiscriminatorValue("DECIMAL")
public class BigDecimalAttributeType extends AttributeType {
	
	@Column(name = "MIN_DECIMAL")
	private BigDecimal minValue;
	@Column(name = "MAX_DECIMAL")
	private BigDecimal maxValue;
	
	protected BigDecimalAttributeType() {
		super();
	}

	public BigDecimalAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence, int index) {
		this(code, name, description, mandatory, isValue, multipleOccurence, null, null, index);
	}

	public BigDecimalAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence,
			BigDecimal minValue, BigDecimal maxValue, int index) {
		super(code, name, description, mandatory, isValue, multipleOccurence, index);
		
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new BigDecimalAttribute(this);
	}

}
