package model.element.mobile;

import java.awt.Point;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

/**
 * <h1>The Class Mobile.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class Mobile extends Element implements IMobile {

	private Point position;
	private Boolean alive = true;
	private IMap map;
	private Direction direction;

	/**
	 * A poor constructor of Mobile, used only by the real Mobile constructor
	 * @param sprite
	 * @param map
	 * @param permeability
	 * @param elementType
	 */
	public Mobile(Sprite sprite, IMap map, Permeability permeability, ElementType elementType) {
		super(sprite, permeability, elementType);
		this.setMap(map);
		this.setPosition(new Point());
	}

	/**
	 * The real Mobile constructor, use a light Mobile constructor to work
	 * @param x
	 * @param y
	 * @param direction
	 * @param sprite
	 * @param map
	 * @param permeability
	 * @param elementType
	 */
	public Mobile(int x, int y, Direction direction, Sprite sprite, IMap map, Permeability permeability,
			ElementType elementType) {
		this(sprite, map, permeability, elementType);
		this.setX(x);
		this.setY(y);
		this.setDirection(direction);
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().x;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#setX(int)
	 */
	@Override
	public void setX(int x) {
		this.getPosition().x = x;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().y;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#setY(int)
	 */
	@Override
	public void setY(int y) {
		this.getPosition().y = y;
	}

	/**
	 * The getter of the element position
	 * @return Point position
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * The setter of the element position
	 * @param Point position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * The getter of the map
	 * @return
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * The setter of the map
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#isAlive()
	 */
	@Override
	public boolean isAlive() {
		return alive;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#die()
	 */
	@Override
	public void die() {
		this.alive = false;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getDirection()
	 */
	@Override
	public Direction getDirection() {
		return this.direction;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#setDirection(model.Direction)
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}