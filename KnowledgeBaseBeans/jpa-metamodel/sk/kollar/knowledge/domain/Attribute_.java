package sk.kollar.knowledge.domain;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-10T21:27:44.925+0200")
@StaticMetamodel(Attribute.class)
public class Attribute_ extends PersistentObject_ {
	public static volatile SingularAttribute<Attribute, AttributeType> attributeType;
	public static volatile SingularAttribute<Attribute, Fact> fact;
	public static volatile SetAttribute<Attribute, AttributeKeyWord> attributeKeyWords;
	public static volatile SingularAttribute<Attribute, BigDecimal> computableValue;
}
