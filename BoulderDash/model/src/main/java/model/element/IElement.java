package model.element;

import java.awt.Image;

public interface IElement {

	Sprite getSprite();

	Permeability getPermeability();

	ElementType getElementType();

	Image getImage();

}