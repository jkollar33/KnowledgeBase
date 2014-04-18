package sk.kollar.knowledge.domain.attributetypes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.DoubleAttribute;

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleAttributeType extends AttributeType {
	
	@Column(name = "MIN_DOUBLE")
	private Double minValue;
	@Column(name = "MAX_DOUBLE")
	private Double maxValue;
	
	protected DoubleAttributeType() {
		super();
	}

	public DoubleAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence) {
		this(code, name, description, mandatory, isValue, multipleOccurence, null, null);
	}

	public DoubleAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence,
			Double minValue, Double maxValue) {
		super(code, name, description, mandatory, isValue, multipleOccurence);
		
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new DoubleAttribute(this);
	}

}
