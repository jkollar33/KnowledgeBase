package sk.kollar.knowledge.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-10T21:27:44.949+0200")
@StaticMetamodel(KeyWordRelation.class)
public class KeyWordRelation_ extends PersistentObject_ {
	public static volatile SingularAttribute<KeyWordRelation, KeyWord> parentKeyWord;
	public static volatile SingularAttribute<KeyWordRelation, KeyWord> childKeyWord;
	public static volatile SingularAttribute<KeyWordRelation, Double> weight;
}
