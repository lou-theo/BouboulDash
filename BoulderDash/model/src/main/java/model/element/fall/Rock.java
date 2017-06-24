package model.element.fall;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class Rock.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Rock extends Fall {

	private static char CODE;
	private static String NAME = "Rock";
	private static Permeability PERMEABILITY;
	
	/**
	 * The Rock constructor
	 * @param x
	 * @param y
	 * @param map
	 */
	public Rock(int x, int y, IMap map) {
		super(x, y, new Sprite(CODE, NAME), map, PERMEABILITY);
	}

	/**
	 * Static getter of the rock code
	 * @return char rock code
	 */
	public static char getCODE() {
		return CODE;
	}

	/**
	 * Static setter of the rock code
	 * @param cODE
	 */
	public static void setCODE(char cODE) {
		CODE = cODE;
	}

	/**
	 * Static getter of the rock name
	 * @return String rock name
	 */
	public static String getNAME() {
		return NAME;
	}

	/**
	 * Static setter of the rock name
	 * @param nAME
	 */
	public static void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * Static getter of the rock permeability
	 * @return Permeability rock permeability
	 */
	public static Permeability getPERMEABILITY() {
		return PERMEABILITY;
	}

	/**
	 * Static setter of the rock permeability
	 * @param pERMEABILITY
	 */
	public static void setPERMEABILITY(Permeability pERMEABILITY) {
		PERMEABILITY = pERMEABILITY;
	}

}
