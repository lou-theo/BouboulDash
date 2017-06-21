package model.element.motionless;

import model.ElementType;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public abstract class MotionLessElement extends Element {

	private static ElementType ELEMENT_TYPE = ElementType.MONTIONLESS;
	
	public MotionLessElement(Sprite sprite, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
	}

}
