package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Door extends MotionLessElement{
	private static char CODE;
	private static String NAME = "Door";
	private static Permeability PERMEABILITY;
	
	public Door() {
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
