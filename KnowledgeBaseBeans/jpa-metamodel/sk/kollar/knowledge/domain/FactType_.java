package sk.kollar.knowledge.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-10T21:27:44.947+0200")
@StaticMetamodel(FactType.class)
public class FactType_ extends PersistentObject_ {
	public static volatile SingularAttribute<FactType, String> code;
	public static volatile SingularAttribute<FactType, String> name;
	public static volatile SingularAttribute<FactType, String> description;
	public static volatile ListAttribute<FactType, AttributeType> attributeTypes;
}
