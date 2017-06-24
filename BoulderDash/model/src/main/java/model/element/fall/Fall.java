package model.element.fall;

import java.awt.Point;

import model.ElementType;
import model.IFall;
import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.Element;

/**
 * <h1>The Class Fall.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Fall extends Element implements IFall {

	private Point position;
	private IMap map;

	private static ElementType ELEMENT_TYPE = ElementType.FALL;

	/**
	 * A poor constructor of fall, used only by the real Fall constructor
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	public Fall(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
		this.setMap(map);
		this.setPosition(new Point());
	}

	/**
	 * The real Fall constructor, use a light Fall constructor to work
	 * @param x
	 * @param y
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
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

	/* (non-Javadoc)
	 * @see model.IFall#setX(int)
	 */
	public final void setX(final int x) {
		this.getPosition().x = x;
	}

	/* (non-Javadoc)
	 * @see model.IFall#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().y;
	}

	/* (non-Javadoc)
	 * @see model.IFall#setY(int)
	 */
	public final void setY(final int y) {
		this.getPosition().y = y;
	}

	/**
	 * The getter of map
	 * @return
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * The setter of map
	 * @param map
	 */
	private void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * The getter of the fall element position
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * The setter of the fall element position
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}
}
