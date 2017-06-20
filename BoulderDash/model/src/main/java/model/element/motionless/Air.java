package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Air extends MotionLessElement {
	private static char CODE;
	private static String NAME = "Air";
	private static Permeability PERMEABILITY;
	
	public Air() {
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
