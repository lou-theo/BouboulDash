package model.element.mobile.mob;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.IMob;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public abstract class Mob extends Mobile implements IMob {

	private boolean drop;
	private int value;
	
	public Mob(int x, int y, boolean drop, int value, Sprite sprite, IMap map, Permeability permeability) {
		super(x, y, Direction.UP, sprite, map, permeability, ElementType.MOB);
		this.setDrop(drop);
		this.setValue(value);
	}

	public boolean isDroppable() {
		return this.drop;
	}
	
	private void setDrop(boolean drop) {
		this.drop = drop;
	}

	public int getValue() {
		return this.value;
	}
	
	private void setValue(int value) {
		this.value = value;
	}
}
