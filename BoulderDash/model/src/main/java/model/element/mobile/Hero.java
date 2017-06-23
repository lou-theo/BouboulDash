package model.element.mobile;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.Permeability;
import model.Sprite;

public class Hero extends Mobile {

	private static String NAME = "Hero";
	private static char CODE;
	private static Permeability PERMEABILITY;
	
	public Hero(int x, int y, IMap map) {
		super(x, y, Direction.NONE, new Sprite(CODE, NAME), map, PERMEABILITY, ElementType.HERO);
	}

	public static String getNAME() {
		return NAME;
	}

	public static void setNAME(String nAME) {
		NAME = nAME;
	}

	public static char getCODE() {
		return CODE;
	}

	public static void setCODE(char cODE) {
		CODE = cODE;
	}

	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}

	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}
}
