package model.element.mobile.mob;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Spider extends Mob {

	private static char CODE;
	private static String NAME = "Spider";
	private static int VALUE;
	private static boolean DROP;
	private static Permeability PERMEABILITY;
	

	public Spider(int x, int y, IMap map) {
		super(x, y, DROP, VALUE,new Sprite(CODE, NAME), map, PERMEABILITY);
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


	public static int getVALUE() {
		return VALUE;
	}


	public static void setVALUE(int vALUE) {
		VALUE = vALUE;
	}


	public static boolean isDROP() {
		return DROP;
	}


	public static void setDROP(boolean dROP) {
		DROP = dROP;
	}


	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}


	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}

}
