package model.element.motionless;

public abstract class MotionLessElementFactory {
	private static MotionLessElement MUD = null;
	private static MotionLessElement DOOR = null;
	private static MotionLessElement SUPER_WALL = null;
	private static MotionLessElement AIR = null;
	private static MotionLessElement WALL = null;
	
	public static MotionLessElement createMud() {
		if (MUD == null) {
			MUD = new Mud();
		}
		return MUD;
	}
	
	public static MotionLessElement createDoor() {
		if (DOOR == null) {
			DOOR = new Door();
		}
		return DOOR;
	}
	
	public static MotionLessElement createSuperWall() {
		if (SUPER_WALL == null) {
			SUPER_WALL = new SuperWall();
		}
		return SUPER_WALL;
	}
	
	public static MotionLessElement createAir() {
		if (AIR == null) {
			AIR = new Air();
		}
		return AIR;
	}
	
	public static MotionLessElement createWall() {
		if (WALL == null) {
			WALL = new Wall();
		}
		return WALL;
	}
}
