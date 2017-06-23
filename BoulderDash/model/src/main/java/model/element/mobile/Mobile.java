package model.element.mobile;

import java.awt.Point;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {

	private Point position;
	private Boolean alive = true;
	private IMap map;
	private Direction direction;

	public Mobile(Sprite sprite, IMap map, Permeability permeability, ElementType elementType) {
		super(sprite, permeability, elementType);
		this.setMap(map);
		this.setPosition(new Point());
	}

	public Mobile(int x, int y, Direction direction, Sprite sprite, IMap map, Permeability permeability,
			ElementType elementType) {
		this(sprite, map, permeability, elementType);
		this.setX(x);
		this.setY(y);
		this.setDirection(direction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#setX(int)
	 */
	@Override
	public void setX(int x) {
		this.getPosition().x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#setY(int)
	 */
	@Override
	public void setY(int y) {
		this.getPosition().y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#getPosition()
	 */
	public Point getPosition() {
		return this.position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#getMap()
	 */
	public IMap getMap() {
		return this.map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#setMap(model.IMap)
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#isAlive()
	 */
	@Override
	public boolean isAlive() {
		return alive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#die()
	 */
	@Override
	public void die() {
		this.alive = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.mobile.IMobile#getDirection()
	 */
	@Override
	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}