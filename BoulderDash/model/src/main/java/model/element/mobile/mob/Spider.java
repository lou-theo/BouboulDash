package model.element.mobile.mob;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class Spider.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Spider extends Mob {

	private static char CODE;
	private static String NAME = "Spider";
	private static int VALUE;
	private static boolean DROP;
	private static Permeability PERMEABILITY;
	
	/**
	 * The Spider constructor
	 * @param x
	 * @param y
	 * @param map
	 */
	public Spider(int x, int y, IMap map) {
		super(x, y, DROP, VALUE,new Sprite(CODE, NAME), map, PERMEABILITY);
	}

	/**
	 * Static getter of the element code
	 * @return
	 */
	public static char getCODE() {
		return CODE;
	}

	/**
	 * Static setter of the element code
	 * @param cODE
	 */
	public static void setCODE(char cODE) {
		CODE = cODE;
	}

	/**
	 * Static getter of the element name
	 * @return
	 */
	public static String getNAME() {
		return NAME;
	}

	/**
	 * Static setter of the element name
	 * @param nAME
	 */
	public static void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * Static getter of the mob value
	 * @return mob value
	 */
	public static int getVALUE() {
		return VALUE;
	}

	/**
	 * Static setter of the mob value
	 * @param vALUE
	 */
	public static void setVALUE(int vALUE) {
		VALUE = vALUE;
	}

	/** Static, tell if a mob drops diamonds when it dies or not
	 * @return true if it drops diamonds
	 */
	public static boolean isDROP() {
		return DROP;
	}

	/**
	 * Static setter of if a mob can drop diamonds or not
	 * @param dROP
	 */
	public static void setDROP(boolean dROP) {
		DROP = dROP;
	}

	/**
	 * Static getter of the element permeability
	 * @return
	 */
	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}

	/**
	 * Static setter of the element permeability
	 * @param pERMEABILITY
	 */
	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}
}