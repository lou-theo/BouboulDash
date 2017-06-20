package model.element.motionless;

import model.element.Element;
import model.element.ElementType;
import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionLessElement extends Element {

	private static ElementType ELEMENT_TYPE = ElementType.MONTIONLESS;
	
	public MotionLessElement(Sprite sprite, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
	}

}
