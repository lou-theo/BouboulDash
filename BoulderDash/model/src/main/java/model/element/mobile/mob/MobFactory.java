package model.element.mobile.mob;

import model.IMap;
import model.IMob;

public abstract class MobFactory {
	public static IMob createGoblin(int x, int y, IMap map) {
		return new Goblin(x, y, map);
	}
	
	public static IMob createMonster(int x, int y, IMap map) {
		return new Monster(x, y, map);
	}
	
	public static IMob createBat(int x, int y, IMap map) {
		return new Bat(x, y, map);
	}
	
	public static IMob createSpider(int x, int y, IMap map) {
		return new Spider(x, y, map);
	}
}
