package sk.kollar.knowledge.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-10T21:27:44.946+0200")
@StaticMetamodel(Fact.class)
public class Fact_ extends PersistentObject_ {
	public static volatile SingularAttribute<Fact, FactType> factType;
	public static volatile ListAttribute<Fact, Attribute> attributes;
	public static volatile SingularAttribute<Fact, String> name;
	public static volatile SingularAttribute<Fact, String> description;
}
