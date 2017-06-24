package model;

import java.util.Observable;

/**
 * <h1>The Interface IModel.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IModel {

	/**
	 * Get the counter which contains the points of the player and the diamonds left
	 * @return
	 */
	ICounter getCounter();
	
	/**
	 * Get the timer
	 * @return
	 */
	ITimer getTimer();
    
	/**
	 * Get the map with all the element and the hero
	 * @return
	 */
	IMap getMap();
	
	/**
	 * Tell if the player has win or not
	 * @return true if all the diamonds have been collected and the player has passed the door
	 */
	boolean isWin();

	/**
	 * Set if the player has wined or not
	 * @param win
	 */
	void setWin(boolean win);
	
	/**
	 * To be used when the data in the model change (map, timer or counter)
	 */
	void setModelChanged();
    
	/**
	 * Get the observable model
	 * @return
	 */
    public Observable getObservable();
}
