package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * <h1>The Interface IMap.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IMap {

	/**
	 * Give the number of element in the x axis
	 * @return width of the map
	 */
	int getWidth();

	/**
	 * Give the number of element in the y axis
	 * @return height of the map
	 */
	int getHeight();

	/**
	 * Give the element situated on the x and y coordinate of the map
	 * @param x
	 * @param y
	 * @return IElement element
	 */
	IElement getOnTheMapXY(int x, int y);

	/**
	 * Set the element in the x and y coordinate of the map
	 * @param element
	 * @param x
	 * @param y
	 */
	void setOnTheMapXY(IElement element, int x, int y);

	/**
	 * Use when an element has been changed
	 */
	void setMapHasChanged();

	/**
	 * Give the observable for the view : the model
	 * @return the model
	 */
	Observable getObservable();

	/**
	 * Give the Hero element
	 * @return IMobile hero
	 */
	IMobile getMyCharacter();

	/**
	 * Give the list of all mobs
	 * @return ArrayList<IMob> mobs
	 */
	ArrayList<IMob> getMobs();

	/**
	 * Add the given mob to the mob list
	 * @param mob
	 */
	void addMob(IMob mob);

	/**
	 * Remove the given mob of the mob list
	 * @param mob
	 */
	void removeMob(IMob mob);

	/**
	 * Give the list of all falls (diamonds and rocks)
	 * @return ArrayList<IFall> falls
	 */
	ArrayList<IFall> getFalls();

	/**
	 * Add the given fall element to the fall element list
	 * @param fall
	 */
	void addFall(IFall fall);

	/**
	 * Remove the given fall element to the fall element list
	 * @param fall
	 */
	void removeFall(IFall fall);
	
	/**
	 * Move down the hero and makes interactions if needed
	 * @param mobile
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveDown(IMobile mobile);

	/**
	 * Move up the hero and makes interactions if needed
	 * @param mobile
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveUp(IMobile mobile);
	
	/**
	 * Move right the hero and makes interactions if needed
	 * @param mobile
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveRight(IMobile mobile);
	
	/**
	 * Move left the hero and makes interactions if needed
	 * @param mobile
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveLeft(IMobile mobile);
	
	
	/**
	 * Move down the fall element and makes interactions if needed
	 * @param fall
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveDown(IFall fall);

	/**
	 * Move right the fall element and makes interactions if needed
	 * @param fall
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveRight(IFall fall);

	/**
	 * Move left the fall element and makes interactions if needed
	 * @param fall
	 * @return true if there is a move, false if there isn't
	 */
	boolean moveLeft(IFall fall);
	
	/**
	 * kill the mobile element given and makes him explode
	 * @param mobile
	 */
	void die(IMobile mobile);
	
	/**
	 * Move down the mob given and makes interactions if needed
	 * @param mob
	 * @return true if there is a move, false if there isn't
	 */
	public boolean moveDown(IMob mob);

	/**
	 * Move up the mob given and makes interactions if needed
	 * @param mob
	 * @return true if there is a move, false if there isn't
	 */
	public boolean moveUp(IMob mob);

	/**
	 * Move right the mob given and makes interactions if needed
	 * @param mob
	 * @return true if there is a move, false if there isn't
	 */
	public boolean moveRight(IMob mob);

	/**
	 * Move left the mob given and makes interactions if needed
	 * @param mob
	 * @return true if there is a move, false if there isn't
	 */
	public boolean moveLeft(IMob mob);
}