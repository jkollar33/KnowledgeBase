package sk.kollar.knowledge.domain.attributetypes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sk.kollar.knowledge.domain.Attribute;
import sk.kollar.knowledge.domain.AttributeType;
import sk.kollar.knowledge.domain.attributes.TextAttribute;

@Entity
@DiscriminatorValue("TEXT")
public class TextAttributeType extends AttributeType {
	
	@Column
	private Long minLength;
	@Column
	private Long maxLength;
	
	protected TextAttributeType() {
		super();
	}

	public TextAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence, int index) {
		this(code, name, description, mandatory, isValue, multipleOccurence, null, null, index);
	}

	public TextAttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence,
			Long minLength, Long maxLength, int index) {
		super(code, name, description, mandatory, isValue, multipleOccurence, index);
		
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	public long getMinLength() {
		return minLength;
	}

	public void setMinLength(long minLength) {
		this.minLength = minLength;
	}

	public long getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(long maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	protected Attribute<?> createAttributeImpl() {
		return new TextAttribute(this);
	}

}
