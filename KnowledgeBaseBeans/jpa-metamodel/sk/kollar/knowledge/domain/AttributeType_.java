package sk.kollar.knowledge.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-18T20:49:37.369+0200")
@StaticMetamodel(AttributeType.class)
public class AttributeType_ extends PersistentObject_ {
	public static volatile SingularAttribute<AttributeType, FactType> factType;
	public static volatile SingularAttribute<AttributeType, String> code;
	public static volatile SingularAttribute<AttributeType, String> name;
	public static volatile SingularAttribute<AttributeType, String> description;
	public static volatile SingularAttribute<AttributeType, Boolean> mandatory;
	public static volatile SingularAttribute<AttributeType, Boolean> isValue;
	public static volatile SingularAttribute<AttributeType, Boolean> multipleOccurence;
}
