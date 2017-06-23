package model.element.fall;

import java.awt.Point;

import model.ElementType;
import model.IFall;
import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public class Fall extends Element implements IFall {

	private Point position;
	private IMap map;

	private static ElementType ELEMENT_TYPE = ElementType.FALL;

	public Fall(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
		this.setMap(map);
		this.setPosition(new Point());
	}

	public Fall(int x, int y, Sprite sprite, IMap map, Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getY()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getPosition()
	 */
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	
}
