package model.element.fall;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class Diamond.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Diamond extends Fall {
	private static char CODE;
	private static String NAME = "Diamond";
	private static Permeability PERMEABILITY;
	private static Sprite SPRITE = null;
	
	/**
	 * The Diamond constructor
	 * @param x
	 * @param y
	 * @param map
	 */
	public Diamond(int x, int y, IMap map) {
		super(x, y, SPRITE, map, PERMEABILITY);
	}

	/**
	 * Static getter of the Diamond code
	 * @return diamond code
	 */
	public static char getCODE() {
		return CODE;
	}

	/**
	 * Static setter of the diamond code
	 * @param cODE
	 */
	public static void setCODE(char cODE) {
		CODE = cODE;
	}

	/**
	 * Static getter of the diamond name
	 * @return diamond name
	 */
	public static String getNAME() {
		return NAME;
	}

	/**
	 * Static setter of the diamond name
	 * @param nAME
	 */
	public static void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * Static getter of the diamond permeability
	 * @return diamond permeability
	 */
	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}

	/**
	 * Static setter of the diamond permeability
	 * @param pERMEABILITY
	 */
	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}

	/**
	 * Static getter of the diamond sprite
	 * @return diamond sprite
	 */
	public static Sprite getSPRITE() {
		return SPRITE;
	}

	/**
	 * Static setter of the diamond sprite
	 */
	public static void setSPRITE() {
		SPRITE = new Sprite(getCODE(), getNAME());
	}
}
