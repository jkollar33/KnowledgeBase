package sk.kollar.knowledge.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class KeyWordRelation extends PersistentObject {

	@ManyToOne
	@JoinColumn(name = "parent_keyword", nullable = false)
	private KeyWord parentKeyWord;

	@ManyToOne
	@JoinColumn(name = "child_keyword", nullable = false)
	private KeyWord childKeyWord;
	
	/**
	 * @uml.property  name="weight"
	 */
	private double weight;

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
	 * Getter of the property <tt>childKeyWord</tt>
	 * @return  Returns the keyWord.
	 */
	public KeyWord getChildKeyWord() {
		return childKeyWord;
	}

	/**
	 * Setter of the property <tt>childKeyWord</tt>
	 * @param childKeyWord  The keyWord to set.
	 */
	public void setChildKeyWord(KeyWord childKeyWord) {
		this.childKeyWord = childKeyWord;
	}

	/**
	 * Getter of the property <tt>parentKeyWord</tt>
	 * @return  Returns the childKeyWord.
	 */
	public KeyWord getParentKeyWord() {
		return parentKeyWord;
	}

	/**
	 * Setter of the property <tt>parentKeyWord</tt>
	 * @param parentKeyWord  The childKeyWord to set.
	 */
	public void setParentKeyWord(KeyWord parentKeyWord) {
		this.parentKeyWord = parentKeyWord;
	}

}
