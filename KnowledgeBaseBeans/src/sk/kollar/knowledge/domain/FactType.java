package sk.kollar.knowledge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;


@Entity
@Table(name = "fact_type")
public class FactType extends PersistentObject {

	/**
	 * @uml.property  name="code"
	 */
	@Column(nullable = false, unique = true)
	private String code;

	/**
	 * @uml.property  name="name"
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * @uml.property  name="description"
	 */
	private String description;
	
	/** 
	 * @uml.property name="attributeTypes"
	 * @uml.associationEnd multiplicity="(0 -1)" aggregation="shared" inverse="factType:sk.kollar.knowledge.domain.AttributeType"
	 */
	@OneToMany(
			mappedBy = "factType",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			orphanRemoval = true)
	@OrderBy("index ASC")
	private List<AttributeType> attributeTypes;

	public FactType(String code, String name, String description) {
		this();
		
		Validate.notNull(code, "code is required parameter!");
		Validate.notNull(name, "name is required parameter!");

		this.code = code;
		this.name = name;
		this.description = description;
	}

	protected FactType() {
		super();
		
		attributeTypes = new ArrayList<AttributeType>();
	}

	/** 
	 * Getter of the property <tt>attributeType</tt>
	 * @return  Returns unmodifiable view of the attributeTypes.
	 * @uml.property  name="attributeTypes"
	 */
	public List<AttributeType> getAttributeTypes() {
		return Collections.unmodifiableList(attributeTypes);
	}
	
	public void addAttributeType(AttributeType attributeType) {
		Validate.notNull(attributeType, "attributeType is required parameter!");
		
		if (attributeType.getFactType() != null) {
			attributeType.getFactType().removeAttributeType(attributeType);
		}
		
		attributeTypes.add(attributeType);
		attributeType.setFactType(this);
		
		reorderAttributeIndices();
	}

	public void removeAttributeType(AttributeType attributeType) {
		Validate.notNull(attributeType, "attributeType is required parameter!");
		
		attributeTypes.remove(attributeType);
		attributeType.setFactType(null);

		reorderAttributeIndices();
	}
	
	private void reorderAttributeIndices() {
		for (AttributeType attributeType: attributeTypes) {
			attributeType.setIndex(attributeTypes.indexOf(attributeType));
		}
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
	
	public Fact createFact(String name, String description) {
		Validate.notNull(code, "code is mandatory parameter!");
		Validate.notNull(name, "name is mandatory parameter!");

		Fact fact = new Fact(this, name, description);
		
		for (AttributeType attributeType: getAttributeTypes()) {
			fact.addAttribute(attributeType.createAttributeImpl());
		}
		
		return fact;
	}

}
