package model;

/**
 * <h1>The Interface IMob.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IMob extends IMobile {
	 
	/**
	 * Say if the mob drop diamonds when it die or not
	 * @return true if he drop
	 */
	boolean isDroppable();

	/**
	 * Say how many points are given to the player when a mob die
	 * @return int value
	 */
	 int getValue();
}
