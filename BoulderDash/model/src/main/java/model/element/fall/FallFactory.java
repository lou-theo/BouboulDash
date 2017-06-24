package model.element.fall;

import model.IFall;
import model.IMap;

/**
 * <h1>The Class FallFactory.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class FallFactory {
	
	/**
	 * Create a rock to the specified coordinate
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IFall createRock(int x, int y, IMap map) {
		return new Rock(x, y, map);
	}
	
	/**
	 * Create a diamond to the specified coordinate
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IFall createDiamond(int x, int y, IMap map) {
		return new Diamond(x, y, map);
	}
}
