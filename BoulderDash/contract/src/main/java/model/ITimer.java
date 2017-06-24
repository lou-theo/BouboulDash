package model;

/**
 * <h1>The Interface ITimer.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface ITimer {

	/**
	 * Get the time before the game over
	 * @return
	 */
	int getTime();

	/**
	 * Launch the timer
	 */
	void timeGo();

	/**
	 * Tell if the timer = 0
	 * @return true if the time is away
	 */
	boolean isTimeAway();

	/**
	 * Set if the game is over or not
	 * @param gameFinished
	 */
	void setGameFinished(boolean gameFinished);
}