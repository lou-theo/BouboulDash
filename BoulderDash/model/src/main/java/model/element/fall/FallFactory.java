package model.element.fall;

import model.IFall;
import model.IMap;

public abstract class FallFactory {
	public static IFall createRock(int x, int y, IMap map) {
		return new Rock(x, y, map);
	}
	
	public static IFall createDiamond(int x, int y, IMap map) {
		return new Diamond(x, y, map);
	}
}
