package sk.kollar.knowledge.domain.attributes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;

@Entity
@DiscriminatorValue("STRING")
public class TextAttribute extends Attribute<String> {
	
	@Column(name = "STRING_VALUE")
	private String value;

	protected TextAttribute() {
	}
	
	public TextAttribute(AttributeType attributeType) {
		super(attributeType);
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

}
