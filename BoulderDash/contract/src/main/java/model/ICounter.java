package model;

/**
 * <h1>The Interface ICounter.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface ICounter {

	/**
	 * Give the points of the user
	 * @return int point
	 */
	int getPoint();

	/**
	 * Give how many diamonds have to be collected
	 * @return int diamondLeft
	 */
	int getDiamondLeft();

	/**
	 * Add the the number of points given to the counter
	 * @param int point
	 */
	void addPoint(int point);

	/**
	 * Remove one diamond from the counter which show how many diamonds have to be collected
	 */
	void removeOneDiamond();

}