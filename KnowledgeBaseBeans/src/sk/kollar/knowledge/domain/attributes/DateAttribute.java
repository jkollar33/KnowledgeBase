package sk.kollar.knowledge.domain.attributes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("DATE")
public class DateAttribute extends Attribute<Date> {
	
	@Column(name = "DATE_VALUE")
	private Date value;

	protected DateAttribute() {
	}
	
	public DateAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public Date getValue() {
		return value;
	}

	@Override
	public void setValue(Date value) {
		this.value = value;
	}

}
