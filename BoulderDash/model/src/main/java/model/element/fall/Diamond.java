package model.element.fall;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Diamond extends Fall {
	private static char CODE;
	private static String NAME = "Diamond";
	private static Permeability PERMEABILITY;
	private static Sprite SPRITE = null;
	
	public Diamond(int x, int y, IMap map) {
		super(x, y, SPRITE, map, PERMEABILITY);
	}

	public static char getCODE() {
		return CODE;
	}

	public static void setCODE(char cODE) {
		CODE = cODE;
	}

	public static String getNAME() {
		return NAME;
	}

	public static void setNAME(String nAME) {
		NAME = nAME;
	}

	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}

	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}

	public static Sprite getSPRITE() {
		return SPRITE;
	}

	public static void setSPRITE() {
		SPRITE = new Sprite(getCODE(), getNAME());
	}
}
