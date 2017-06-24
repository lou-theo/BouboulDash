package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class Mud.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Mud extends MotionLessElement {

	private static char CODE;
	private static String NAME = "Mud";
	private static Permeability PERMEABILITY;
	
	/**
	 * The Mud constructor
	 */
	public Mud() {
		super(new Sprite(CODE, NAME), PERMEABILITY);
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
