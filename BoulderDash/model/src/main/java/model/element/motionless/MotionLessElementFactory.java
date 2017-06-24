package model.element.motionless;

/**
 * <h1>The Class MotionLessElementFactory.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class MotionLessElementFactory {
	private static MotionLessElement MUD = null;
	private static MotionLessElement DOOR = null;
	private static MotionLessElement SUPER_WALL = null;
	private static MotionLessElement AIR = null;
	private static MotionLessElement WALL = null;
	
	/**
	 * Create Mud to the specified coordinate
	 * @return
	 */
	public static MotionLessElement createMud() {
		if (MUD == null) {
			MUD = new Mud();
		}
		return MUD;
	}
	
	/**
	 * Create a Door to the specified coordinate
	 * @return
	 */
	public static MotionLessElement createDoor() {
		if (DOOR == null) {
			DOOR = new Door();
		}
		return DOOR;
	}
	
	/**
	 * Create a SuperWall to the specified coordinate
	 * @return
	 */
	public static MotionLessElement createSuperWall() {
		if (SUPER_WALL == null) {
			SUPER_WALL = new SuperWall();
		}
		return SUPER_WALL;
	}
	
	/**
	 * Create Air to the specified coordinate
	 * @return
	 */
	public static MotionLessElement createAir() {
		if (AIR == null) {
			AIR = new Air();
		}
		return AIR;
	}
	
	/**
	 * Create a Wall to the specified coordinate
	 * @return
	 */
	public static MotionLessElement createWall() {
		if (WALL == null) {
			WALL = new Wall();
		}
		return WALL;
	}
}
