package model.element.mobile;

import model.Direction;
import model.ElementType;
import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class Hero.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Hero extends Mobile {

	private static String NAME = "Hero";
	private static char CODE;
	private static Permeability PERMEABILITY;
	
	/**
	 * The Hero constructor
	 * @param x
	 * @param y
	 * @param map
	 */
	public Hero(int x, int y, IMap map) {
		super(x, y, Direction.NONE, new Sprite(CODE, NAME), map, PERMEABILITY, ElementType.HERO);
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
