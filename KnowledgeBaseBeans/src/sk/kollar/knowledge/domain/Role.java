package sk.kollar.knowledge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "APP_ROLE")
public class Role extends PersistentObject {

	/**
	 * @uml.property  name="code"
	 */
	@Column(nullable = false)
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

}
