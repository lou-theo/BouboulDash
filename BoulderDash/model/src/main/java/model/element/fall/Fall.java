package model.element.fall;

import java.awt.Point;

import model.IMap;
import model.element.Element;
import model.element.ElementType;
import model.element.Permeability;
import model.element.Sprite;

public class Fall extends Element {

	private Point position;
	private IMap map;
	
	private static ElementType ELEMENT_TYPE = ElementType.MONTIONLESS;
	
	public Fall(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
		this.setMap(map);
		
	}

	public Fall(int x, int y, Sprite sprite, IMap map, Permeability permeability) {
		this(sprite, map, permeability);
	}

	public void moveDown() {
		if (getX() < this.map.ge)
	}
	
	public int getX() {
        return this.getPosition().x;
	}
	
	public final void setX(final int x) {
        this.getPosition().x = x;
    }
	
	public int getY() {
        return this.getPosition().y;
	}
	
	public final void setY(final int y) {
        this.getPosition().y = y;
    }
	
	public IMap getMap() {
		return map;
	}

	private void setMap(IMap map) {
		this.map = map;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return true if can fall (rien en dessous)
	 * 			false sinon
	 */
	public boolean isFalling() {
		return false;
	}
}
