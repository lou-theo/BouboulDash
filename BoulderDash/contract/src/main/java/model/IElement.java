package model;

import java.awt.Image;

/**
 * <h1>The Interface IElement.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IElement {

	/**
	 * Give the sprite of the associated element
	 * @return Sprite sprite
	 */
	Sprite getSprite();

	/**
	 * Give the permeability of the element
	 * @return Permeability permeability
	 */
	Permeability getPermeability();

	/**
	 * Give the ElementType of the element
	 * @return ElementType elementType
	 */
	ElementType getElementType();

	/**
	 * Give the image of the element, loaded with the sprite
	 * @return Image image
	 */
	Image getImage();

}