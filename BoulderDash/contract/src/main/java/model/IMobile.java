package model;

/**
 * <h1>The Interface IMobile.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IMobile {

	/**
	 * Give the coordinate x of the IMobile element
	 * @return int x
	 */
	int getX();

	/**
	 * Set the coordinate x of the IMobile element
	 * @param i
	 */
	void setX(int x);

	/**
	 * Give the coordinate y of the IMobile element
	 * @return int y
	 */
	int getY();

	/**
	 * Set the coordinate y of the IMobile element
	 * @param i
	 */
	void setY(int y);

	/**
	 * Tell is the IMobile element is alive or not
	 * @return true if is not dead
	 */
	boolean isAlive();

	/**
	 * kill the IMobile element
	 */
	void die();

	/**
	 * Get the direction of the IMobile element
	 * @return direction
	 */
	Direction getDirection();

	/**
	 * Set the direction of the IMobile element
	 * @param direction
	 */
	void setDirection(Direction direction);
}