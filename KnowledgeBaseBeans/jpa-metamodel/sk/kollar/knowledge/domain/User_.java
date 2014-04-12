package sk.kollar.knowledge.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-10T21:27:44.953+0200")
@StaticMetamodel(User.class)
public class User_ extends PersistentObject_ {
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SetAttribute<User, UserFact> userFacts;
	public static volatile SetAttribute<User, Role> userRoles;
}
