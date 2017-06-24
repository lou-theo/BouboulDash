package model.element.mobile.mob;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.IMob;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

/**
 * <h1>The Class Mob.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class Mob extends Mobile implements IMob {

	private boolean drop;
	private int value;
	
	/**
	 * The mob constructor
	 * @param x
	 * @param y
	 * @param drop
	 * @param value
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	public Mob(int x, int y, boolean drop, int value, Sprite sprite, IMap map, Permeability permeability) {
		super(x, y, Direction.UP, sprite, map, permeability, ElementType.MOB);
		this.setDrop(drop);
		this.setValue(value);
	}

	/* (non-Javadoc)
	 * @see model.IMob#isDroppable()
	 */
	public boolean isDroppable() {
		return this.drop;
	}
	
	/**
	 * The setter of drop, set if a mob drops diamonds when it dies or 
	 * @param drop
	 */
	private void setDrop(boolean drop) {
		this.drop = drop;
	}

	/* (non-Javadoc)
	 * @see model.IMob#getValue()
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * The setter of the mob value
	 * @param value
	 */
	private void setValue(int value) {
		this.value = value;
	}
}
