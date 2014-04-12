package sk.kollar.knowledge.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserFact extends PersistentObject {

	/** 
	 * @uml.property name="fact"
	 * @uml.associationEnd inverse="userFacts:sk.kollar.knowledge.domain.Fact"
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fact fact;

	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  inverse="userFacts:sk.kollar.knowledge.domain.User"
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;

	/** 
	 * Getter of the property <tt>fact</tt>
	 * @return  Returns the fact.
	 * @uml.property  name="fact"
	 */
	public Fact getFact() {
		return fact;
	}

	/** 
	 * Setter of the property <tt>fact</tt>
	 * @param fact  The fact to set.
	 * @uml.property  name="fact"
	 */
	public void setFact(Fact fact) {
		this.fact = fact;
	}

	/**
	 * Getter of the property <tt>user</tt>
	 * @return  Returns the user.
	 * @uml.property  name="user"
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter of the property <tt>user</tt>
	 * @param user  The user to set.
	 * @uml.property  name="user"
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
