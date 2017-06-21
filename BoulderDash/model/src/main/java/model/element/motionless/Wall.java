package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class Wall extends MotionLessElement {
	private static char CODE;
	private static String NAME = "Wall";
	private static Permeability PERMEABILITY;
	
	public Wall() {
		super(new Sprite(CODE, NAME), PERMEABILITY);
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
