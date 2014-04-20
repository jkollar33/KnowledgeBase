package sk.kollar.knowledge.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

@Entity
@Table(name = "APP_USER")
public class User extends PersistentObject {

	/**
	 * @uml.property  name="userName"
	 */
	@Column(nullable = false, unique = true)
	private String userName;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="firstName"
	 */
	@Column(nullable = false)
	private String firstName;
	/**
	 * @uml.property  name="lastName"
	 */
	@Column(nullable = false)
	private String lastName;
	/**
	 * @uml.property  name="userFacts"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="user:sk.kollar.knowledge.domain.UserFact"
	 */
	@OneToMany(mappedBy = "user")
	private Set<UserFact> userFacts;

	
	/**
	 * @uml.property   name="userRoles"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="user:sk.kollar.knowledge.domain.Role"
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "user_roles",
			joinColumns = {@JoinColumn(name = "app_user", nullable = false)},
			inverseJoinColumns = {@JoinColumn(name = "app_role", nullable = false)})
	private Set<Role> userRoles;
	
	public User() {
	}

	public User(String userName, String password, String firstName,
			String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Getter of the property <tt>userName</tt>
	 * @return  Returns the userName.
	 * @uml.property  name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of the property <tt>userName</tt>
	 * @param userName  The userName to set.
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter of the property <tt>password</tt>
	 * @return  Returns the password.
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>password</tt>
	 * @param password  The password to set.
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter of the property <tt>userFacts</tt>
	 * @return  Returns the userFacts.
	 * @uml.property  name="userFacts"
	 */
	private Set<UserFact> getUserFacts() {
		if (userFacts == null) {
			userFacts = new HashSet<UserFact>();
		}
		return userFacts;
	}
	
	public void addUserFact(UserFact userFact) {
		Validate.notNull(userFact, "userFact is required parameter!");
		
		getUserFacts().add(userFact);
	}

	public void removeUserFact(UserFact userFact) {
		Validate.notNull(userFact, "userFact is required parameter!");
		
		getUserFacts().remove(userFact);
	}

	/**
	 * Setter of the property <tt>userFacts</tt>
	 * @param userFacts  The userFacts to set.
	 * @uml.property  name="userFacts"
	 */
	public void setUserFacts(Set<UserFact> userFacts) {
		this.userFacts = userFacts;
	}

	/**
	 * Getter of the property <tt>userRoles</tt>
	 * @return  Returns the userRoles.
	 * @uml.property  name="userRoles"
	 */
	private Set<Role> getUserRoles() {
		if (userRoles == null) {
			userRoles = new HashSet<Role>();
		}
		return userRoles;
	}
	
	public void addRole(Role role) {
		Validate.notNull(role, "role is required parameter!");
		
		getUserRoles().add(role);
	}

	public void removeRole(Role role) {
		Validate.notNull(role, "role is required parameter!");
		
		getUserRoles().remove(role);
	}

	/**
	 * Setter of the property <tt>userRoles</tt>
	 * @param userRoles  The userRoles to set.
	 * @uml.property  name="userRoles"
	 */
	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * Getter of the property <tt>firstName</tt>
	 * @return  Returns the firstName.
	 * @uml.property  name="firstName"
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter of the property <tt>firstName</tt>
	 * @param firstName  The firstName to set.
	 * @uml.property  name="firstName"
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter of the property <tt>lastName</tt>
	 * @return  Returns the lastName.
	 * @uml.property  name="lastName"
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter of the property <tt>lastName</tt>
	 * @param lastName  The lastName to set.
	 * @uml.property  name="lastName"
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
