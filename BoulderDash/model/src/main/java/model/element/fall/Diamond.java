package model.element.fall;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Diamond extends Fall {
	private static char CODE;
	private static String NAME = "Diamond";
	private static Permeability PERMEABILITY;
	
	public Diamond(int x, int y, IMap map) {
		super(x, y, new Sprite(CODE, NAME), map, PERMEABILITY);
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
}
