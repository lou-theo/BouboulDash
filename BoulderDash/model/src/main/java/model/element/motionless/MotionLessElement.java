package model.element.motionless;

import model.ElementType;
import model.Permeability;
import model.Sprite;
import model.element.Element;

/**
 * <h1>The Class MotionLessElement.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class MotionLessElement extends Element {

	private static ElementType ELEMENT_TYPE = ElementType.MONTIONLESS;
	
	/**
	 * The MotionLessElement constructor
	 * @param sprite
	 * @param permeability
	 */
	public MotionLessElement(Sprite sprite, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
	}

}
