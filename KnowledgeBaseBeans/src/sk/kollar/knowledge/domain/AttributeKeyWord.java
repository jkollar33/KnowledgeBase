package sk.kollar.knowledge.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ATTRIBUTE_KEY_WORD")
public class AttributeKeyWord extends PersistentObject {

	/**
	 * @uml.property  name="attribute"
	 * @uml.associationEnd  inverse="keyWords:sk.kollar.knowledge.domain.Attribute"
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private Attribute<?> attribute;

	/**
	 * @uml.property  name="keyWord"
	 * @uml.associationEnd  inverse="attributeKeyWord:sk.kollar.knowledge.domain.KeyWord"
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private KeyWord keyWord;

	/**
	 * @uml.property  name="weight"
	 */
	private double weight;

	/**
	 * Getter of the property <tt>keyWord</tt>
	 * @return  Returns the keyWord.
	 * @uml.property  name="keyWord"
	 */
	public KeyWord getKeyWord() {
		return keyWord;
	}

	/**
	 * Setter of the property <tt>keyWord</tt>
	 * @param keyWord  The keyWord to set.
	 * @uml.property  name="keyWord"
	 */
	public void setKeyWord(KeyWord keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * Getter of the property <tt>weight</tt>
	 * @return  Returns the weight.
	 * @uml.property  name="weight"
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter of the property <tt>weight</tt>
	 * @param weight  The weight to set.
	 * @uml.property  name="weight"
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Getter of the property <tt>attribute</tt>
	 * @return  Returns the attribute.
	 * @uml.property  name="attribute"
	 */
	public Attribute<?> getAttribute() {
		return attribute;
	}

	/**
	 * Setter of the property <tt>attribute</tt>
	 * @param attribute  The attribute to set.
	 * @uml.property  name="attribute"
	 */
	public void setAttribute(Attribute<?> attribute) {
		this.attribute = attribute;
	}

}
