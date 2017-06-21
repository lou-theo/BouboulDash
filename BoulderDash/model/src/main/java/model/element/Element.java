package model.element;

import java.awt.Image;

import model.ElementType;
import model.IElement;
import model.Permeability;
import model.Sprite;

public abstract class Element implements IElement {
	protected Sprite sprite;
	private Permeability permeability;
	private ElementType elementType;
	
	public Element(Sprite sprite, Permeability permeability, ElementType elementType) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
		this.setElementType(elementType);
	}

	/* (non-Javadoc)
	 * @see model.IElement#getSprite()
	 */
	@Override
	public Sprite getSprite() {
		return sprite;
	}

	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/* (non-Javadoc)
	 * @see model.IElement#getPermeability()
	 */
	@Override
	public Permeability getPermeability() {
		return permeability;
	}

	private void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/* (non-Javadoc)
	 * @see model.IElement#getElementType()
	 */
	@Override
	public ElementType getElementType() {
		return elementType;
	}

	private void setElementType(ElementType elementType) {
		this.elementType = elementType;
	}
	
	/* (non-Javadoc)
	 * @see model.IElement#getImage()
	 */
	@Override
	public final Image getImage() {
        return this.getSprite().getImage();
    }
}
