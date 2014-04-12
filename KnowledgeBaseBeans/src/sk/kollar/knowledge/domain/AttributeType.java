package sk.kollar.knowledge.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

import sk.kollar.knowledge.domain.attributetypes.BigDecimalAttributeType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VALUE_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "ATTRIBUTE_TYPE")
public abstract class AttributeType extends PersistentObject {

	/** 
	 * @uml.property name="factType"
	 * @uml.associationEnd inverse="attributeTypes:sk.kollar.knowledge.domain.FactType"
	 */
	@ManyToOne
	@JoinColumn(name = "fact_type", nullable = false)
	private FactType factType;

	/**
	 * Code of the attribute type. Code should be unique among all attribute types.
	 * @uml.property  name="code"
	 */
	@Column(nullable = false, unique = true)
	private String code;

	/**
	 * Human-readible name of this attribute type.
	 * @uml.property  name="name"
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * Description of this attribute type.
	 * @uml.property  name="description"
	 */
	private String description;

	/**
	 * If this attribute type is mandatory.
	 * @uml.property  name="mandatory"
	 */
	@Column(nullable = false)
	private boolean mandatory;

	/**
	 * If {@link Attribute} of this type can be used in evaluations. Even if the type
	 * itself represents computable value, for example {@link BigDecimalAttributeType},
	 * it doesn't have to be used in computations (it can be informative).
	 * @uml.property  name="isValue"
	 */
	@Column(nullable = false)
	private boolean isValue;
	
	/**
	 * If one  {@link Fact}  can have multiple {@link Attribute}s of this type.
	 * @uml.property  name="multipleOccurence"
	 */
	@Column(nullable = false)
	private boolean multipleOccurence;

	/**
	 * @uml.property  name="index"
	 */
	private int index;

	protected AttributeType() {
	}

	public AttributeType(String code, String name, String description,
			boolean mandatory, boolean isValue, boolean multipleOccurence, int index) {
		super();

		Validate.notNull(code, "code is required parameter!");
		Validate.notNull(name, "name is required parameter!");

		this.code = code;
		this.name = name;
		this.description = description;
		this.mandatory = mandatory;
		this.isValue = isValue;
		this.multipleOccurence = multipleOccurence;
		this.index = index;
	}

	/** 
	 * Getter of the property <tt>factType</tt>
	 * @return  Returns the factType.
	 * @uml.property  name="factType"
	 */
	public FactType getFactType() {
		return factType;
	}

	/** 
	 * Setter of the property <tt>factType</tt>
	 * @param factType  The factType to set.
	 * @uml.property  name="factType"
	 */
	public void setFactType(FactType factType) {
		this.factType = factType;
	}

	/**
	 * Getter of the property <tt>code</tt>
	 * @return  Returns the code.
	 * @uml.property  name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter of the property <tt>code</tt>
	 * @param code  The code to set.
	 * @uml.property  name="code"
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter of the property <tt>description</tt>
	 * @return  Returns the description.
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter of the property <tt>description</tt>
	 * @param description  The description to set.
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter of the property <tt>mandatory</tt>
	 * @return  Returns the mandatory.
	 * @uml.property  name="mandatory"
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * Setter of the property <tt>mandatory</tt>
	 * @param mandatory  The mandatory to set.
	 * @uml.property  name="mandatory"
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * Getter of the property <tt>isValue</tt>
	 * @return  Returns the isValue.
	 * @uml.property  name="isValue"
	 */
	public boolean isIsValue() {
		return isValue;
	}

	/**
	 * Setter of the property <tt>isValue</tt>
	 * @param isValue  The isValue to set.
	 * @uml.property  name="isValue"
	 */
	public void setIsValue(boolean isValue) {
		this.isValue = isValue;
	}

	/**
	 * Getter of the property <tt>multipleOccurence</tt>
	 * @return  Returns the multipleOccurence.
	 * @uml.property  name="multipleOccurence"
	 */
	public boolean isMultipleOccurence() {
		return multipleOccurence;
	}

	/**
	 * Setter of the property <tt>multipleOccurence</tt>
	 * @param multipleOccurence  The multipleOccurence to set.
	 * @uml.property  name="multipleOccurence"
	 */
	public void setMultipleOccurence(boolean multipleOccurence) {
		this.multipleOccurence = multipleOccurence;
	}

	/**
	 * Getter of the property <tt>index</tt>
	 * @return  Returns the index.
	 * @uml.property  name="index"
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Setter of the property <tt>index</tt>
	 * @param index  The index to set.
	 * @uml.property  name="index"
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	public final Attribute<?> createAttribute() {
		return createAttributeImpl();
	}

	protected abstract Attribute<?> createAttributeImpl();

}
