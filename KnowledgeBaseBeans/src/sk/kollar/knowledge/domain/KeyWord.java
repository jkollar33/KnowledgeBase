package sk.kollar.knowledge.domain;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.Validate;


@Entity
@Table(name = "KEYWORD")
public class KeyWord extends PersistentObject {

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
	 * @uml.property name="childrenKeyWordRelation"
	 */
	@Transient
	private Set<KeyWordRelation> childrenRelations;
	/** 
	 * @uml.property name="keyWordRelationParent"
	 */
	@Transient
	private Set<KeyWordRelation> parentRelations;

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
	 * Getter of the property <tt>childrenKeyWordRelation</tt>
	 * @return  Returns the childrenRelations.
	 * @uml.property  name="childrenKeyWordRelation"
	 */
	public Set<KeyWordRelation> getChildrenKeyWordRelation() {
		return Collections.unmodifiableSet(childrenRelations);
	}
	
	public void addChildRelation(KeyWordRelation keyWordRelation) {
		Validate.notNull(keyWordRelation, "keyWordRelation is required parameter!");
		
		if (keyWordRelation.getChildKeyWord() != null) {
			keyWordRelation.getChildKeyWord().removeParentRelation(keyWordRelation);
		}
		
		keyWordRelation.setParentKeyWord(this);
		this.childrenRelations.add(keyWordRelation);
	}

	/**
	 * Getter of the property <tt>keyWordRelationParent</tt>
	 * @return  Returns the parentRelations.
	 * @uml.property  name="keyWordRelationParent"
	 */
	public Set<KeyWordRelation> getKeyWordRelationParent() {
		return Collections.unmodifiableSet(parentRelations);
	}

	public void addParentRelation(KeyWordRelation keyWordRelation) {
		Validate.notNull(keyWordRelation, "keyWordRelation is required parameter!");
		
		if (keyWordRelation.getChildKeyWord() != null) {
			keyWordRelation.getChildKeyWord().removeParentRelation(keyWordRelation);
		}
		
		keyWordRelation.setChildKeyWord(this);
		this.parentRelations.add(keyWordRelation);
	}
	
	public void removeParentRelation(KeyWordRelation keyWordRelation) {
		Validate.notNull(keyWordRelation, "keyWordRelation is required parameter!");
		
		this.parentRelations.remove(keyWordRelation);
		keyWordRelation.setChildKeyWord(null);
	}

}
