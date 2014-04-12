package sk.kollar.knowledge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.apache.commons.lang3.Validate;


@Entity
public class Fact extends PersistentObject {

	/** 
	 * @uml.property name="factType"
	 * @uml.associationEnd inverse="fact:sk.kollar.knowledge.domain.FactType"
	 */
	@ManyToOne
	@JoinColumn(name = "fact_type", nullable = false)
	private FactType factType;
	
	/** 
	 * @uml.property name="attribute"
	 * @uml.associationEnd multiplicity="(0 -1)" aggregation="shared" inverse="fact:sk.kollar.knowledge.domain.Attribute"
	 */
	@OneToMany(mappedBy = "fact", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@OrderBy("index ASC")
	private List<Attribute<?>> attributes;

	/**
	 * @uml.property  name="name"
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * @uml.property  name="description"
	 */
	private String description;

	public Fact() {
		attributes = new ArrayList<Attribute<?>>();
	}

	public Fact(FactType factType, String name, String description) {
		this();
		
		Validate.notNull(factType, "factType is mandatory parameter!");
		Validate.notNull(name, "name is mandatory parameter!");
		
		this.factType = factType;
		this.name = name;
		this.description = description;
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
	 * Getter of the property <tt>attribute</tt>
	 * @return  Returns the attribute.
	 * @uml.property  name="attribute"
	 */
	public List<Attribute<?>> getAttributes() {
		return Collections.unmodifiableList(attributes);
	}

	public void addAttribute(Attribute<?> attribute) {
		Validate.notNull(attribute, "attribute is required parameter!");

		if (attribute.getFact() != null) {
			attribute.getFact().removeAttribute(attribute);
		}

		attributes.add(attribute);
		attribute.setFact(this);
	}

	public void removeAttribute(Attribute<?> attribute) {
		if (attribute != null) {
			attributes.remove(attribute);
			attribute.setFact(null);
		}
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

	//	/** 
	//	 * Setter of the property <tt>attribute</tt>
	//	 * @param attribute  The attribute to set.
	//	 * @uml.property  name="attribute"
	//	 */
	//	public void setAttributes(Set<Attribute> attribute) {
	//		this.attributes = attribute;
	//	}


}
