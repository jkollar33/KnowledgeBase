package sk.kollar.knowledge.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-19T21:28:21.014+0200")
@StaticMetamodel(UserFact.class)
public class UserFact_ extends PersistentObject_ {
	public static volatile SingularAttribute<UserFact, Fact> fact;
	public static volatile SingularAttribute<UserFact, User> user;
	public static volatile SingularAttribute<UserFact, Date> dateObtained;
}
