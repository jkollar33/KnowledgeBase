package sk.kollar.knowledge.domain.attributetypes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.DateAttribute;


@Entity
@DiscriminatorValue("DATE")
public class DateAttributeType extends AttributeType {
	
	@Column(name = "MIN_DATE")
	private Date minValue;
	@Column(name = "MAX_DATE")
	private Date maxValue;
	
	public DateAttributeType() {
	}

	public DateAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence) {
		this(code, name, description, mandatory, isValue, multipleOccurence, null, null);
	}

	private DateAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence,
			Date minValue, Date maxValue) {
		super(code, name, description, mandatory, isValue, multipleOccurence);
		
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Date getMinValue() {
		return minValue;
	}

	public void setMinValue(Date minValue) {
		this.minValue = minValue;
	}

	public Date getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Date maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new DateAttribute(this);
	}

}
