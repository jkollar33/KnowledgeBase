package sk.kollar.knowledge.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VALUE_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "ATTRIBUTE")
public abstract class Attribute<T> extends PersistentObject {

	/** 
	 * @uml.property name="attributeType"
	 * @uml.associationEnd inverse="attribute:sk.kollar.knowledge.domain.AttributeType"
	 */
	@ManyToOne
	@JoinColumn(name = "attribute_type", nullable = false)
	private AttributeType attributeType;

	/** 
	 * @uml.property name="fact"
	 * @uml.associationEnd inverse="attribute:sk.kollar.knowledge.domain.Fact"
	 */
	@ManyToOne
	@JoinColumn(name = "fact", nullable = false)
	private Fact fact;

	/** 
	 * @uml.property name="keyWords"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="attribute:sk.kollar.knowledge.domain.AttributeKeyWord"
	 */
	@OneToMany(mappedBy = "attribute")
	private Set<AttributeKeyWord> attributeKeyWords;
	
	/**
	 * Value that will be used in computings.
	 * @uml.property  name="computableValue"
	 */
	private BigDecimal computableValue;
	
	protected Attribute() {
	}
	
	public Attribute(AttributeType attributeType) {
		super();
		
		Validate.notNull(attributeType, "attributeType is mandatory parameter!");
		
		this.attributeType = attributeType;
	}



	/** 
	 * Getter of the property <tt>attributeType</tt>
	 * @return  Returns the attributeType.
	 * @uml.property  name="attributeType"
	 */
	public AttributeType getAttributeType() {
		return attributeType;
	}

	/** 
	 * Setter of the property <tt>attributeType</tt>
	 * @param attributeType  The attributeType to set.
	 * @uml.property  name="attributeType"
	 */
	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	/** 
	 * Getter of the property <tt>fact</tt>
	 * @return  Returns the fact.
	 * @uml.property  name="fact"
	 */
	public Fact getFact() {
		return fact;
	}

	/** 
	 * Setter of the property <tt>fact</tt>. Shouldn't be called from outside
	 * expect from {@link Fact#addAttribute(Attribute)}.
	 * @param fact  The fact to set.
	 * @uml.property  name="fact"
	 */
	public void setFact(Fact fact) {
		this.fact = fact;
	}

	/** 
	 * Getter of the property <tt>keyWords</tt>
	 * @return  Returns the attributeKeyWords.
	 * @uml.property  name="keyWords"
	 */
	public Set<AttributeKeyWord> getKeyWords() {
		return attributeKeyWords;
	}

	public void addAttributeKeyWord(AttributeKeyWord attributeKeyWord) {
		attributeKeyWords.add(attributeKeyWord);
	}

	public void removeAttributeKeyWord(AttributeKeyWord attributeKeyWord) {
		attributeKeyWords.remove(attributeKeyWord);
	}

	/** 
	 * Getter of the property <tt>value</tt>
	 * @return  Returns the value.
	 * @uml.property  name="computableValue"
	 */
	public BigDecimal getComputableValue() {
		return computableValue;
	}

	/** 
	 * Setter of the property <tt>value</tt>
	 * @param value  The value to set.
	 * @uml.property  name="computableValue"
	 */
	public void setComputableValue(BigDecimal computableValue) {
		this.computableValue = computableValue;
	}
	
	public abstract T getValue();
	
	public abstract void setValue(T value);

	/**
	 * Setter of the property <tt>keyWords</tt>
	 * @param keyWords  The attributeKeyWords to set.
	 * @uml.property  name="keyWords"
	 */
	public void setKeyWords(Set<AttributeKeyWord> keyWords) {
		attributeKeyWords = keyWords;
	}

}
