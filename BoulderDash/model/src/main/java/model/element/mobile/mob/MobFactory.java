package model.element.mobile.mob;

import model.IMap;
import model.IMob;

/**
 * <h1>The Class MotionLessElementFactory.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class MobFactory {

	/**
	 * Create a Goblin to the specified coordinates
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IMob createGoblin(int x, int y, IMap map) {
		return new Goblin(x, y, map);
	}
	
	/**
	 *  Create a Monster to the specified coordinates
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IMob createMonster(int x, int y, IMap map) {
		return new Monster(x, y, map);
	}
	
	/**
	 * Create a Bat to the specified coordinates
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IMob createBat(int x, int y, IMap map) {
		return new Bat(x, y, map);
	}
	
	/**
	 * Create a Spider to the specified coordinates
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static IMob createSpider(int x, int y, IMap map) {
		return new Spider(x, y, map);
	}
}
