package sk.kollar.knowledge.domain.attributetypes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.IntegerAttribute;

@Entity
@DiscriminatorValue("INTEGER")
public class IntegerAttributeType extends AttributeType {
	
	@Column(name = "MIN_INT")
	private Integer minValue;
	@Column(name = "MAX_INT")
	private Integer maxValue;
	
	protected IntegerAttributeType() {
		super();
	}

	public IntegerAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence) {
		this(code, name, description, mandatory, isValue, multipleOccurence, null, null);
	}

	public IntegerAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence,
			Integer minValue, Integer maxValue) {
		super(code, name, description, mandatory, isValue, multipleOccurence);
		
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new IntegerAttribute(this);
	}

}
