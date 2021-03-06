package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.Brick;
import model.dao.BrickDAO;
import model.dao.MapDAO;
import model.element.fall.Diamond;
import model.element.fall.FallFactory;
import model.element.fall.Rock;
import model.element.mobile.Hero;
import model.element.mobile.mob.Bat;
import model.element.mobile.mob.Goblin;
import model.element.mobile.mob.MobFactory;
import model.element.mobile.mob.Monster;
import model.element.mobile.mob.Spider;
import model.element.motionless.Air;
import model.element.motionless.Door;
import model.element.motionless.MotionLessElementFactory;
import model.element.motionless.Mud;
import model.element.motionless.SuperWall;
import model.element.motionless.Wall;

public class Map implements IMap {
	private int width;
	private int height;
	private IElement[][] onTheMap;
	private ArrayList<IFall> falls = new ArrayList<IFall>();
	private ArrayList<IMob> mobs = new ArrayList<IMob>();
	private IMobile myCharacter;
	private IModel model;

	/**
	 * The map constructor
	 * 
	 * @param level
	 * @param model
	 */
	public Map(int level, IModel model) {
		this.model = model;
		try {
			this.setHeight(MapDAO.getHeight(level));
			this.setWidth(MapDAO.getWidth(level));
			this.loadMap(level);
		} catch (SQLException e) {
			System.out.println("Problem during the map generation");
			e.printStackTrace();
		}
	}

	/**
	 * Load the value from the database and generate the map according to the
	 * data
	 * 
	 * @param level
	 * @throws SQLException
	 */
	private void loadMap(int level) throws SQLException {

		ArrayList<Brick> bricks = new ArrayList<Brick>();

		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		bricks = BrickDAO.getAllbricks(level);

		for (Brick brick : bricks) {
			if (brick.getCode() == Mud.getCODE()) {
				setOnTheMapXY(MotionLessElementFactory.createMud(), brick.getX(), brick.getY());
			} else if (brick.getCode() == Door.getCODE()) {
				setOnTheMapXY(MotionLessElementFactory.createDoor(), brick.getX(), brick.getY());
			} else if (brick.getCode() == SuperWall.getCODE()) {
				setOnTheMapXY(MotionLessElementFactory.createSuperWall(), brick.getX(), brick.getY());
			} else if (brick.getCode() == Air.getCODE()) {
				setOnTheMapXY(MotionLessElementFactory.createAir(), brick.getX(), brick.getY());
			} else if (brick.getCode() == Wall.getCODE()) {
				setOnTheMapXY(MotionLessElementFactory.createWall(), brick.getX(), brick.getY());
			}

			else if (brick.getCode() == Goblin.getCODE()) {
				IMob mob = MobFactory.createGoblin(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) mob, brick.getX(), brick.getY());
				this.addMob(mob);
			} else if (brick.getCode() == Monster.getCODE()) {
				IMob mob = MobFactory.createMonster(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) mob, brick.getX(), brick.getY());
				this.addMob(mob);
			} else if (brick.getCode() == Bat.getCODE()) {
				IMob mob = MobFactory.createBat(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) mob, brick.getX(), brick.getY());
				this.addMob(mob);
			} else if (brick.getCode() == Spider.getCODE()) {
				IMob mob = MobFactory.createSpider(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) mob, brick.getX(), brick.getY());
				this.addMob(mob);
			}

			else if (brick.getCode() == Diamond.getCODE()) {
				IFall fall = FallFactory.createDiamond(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) fall, brick.getX(), brick.getY());
				this.addFall(fall);
			} else if (brick.getCode() == Rock.getCODE()) {
				IFall fall = FallFactory.createRock(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) fall, brick.getX(), brick.getY());
				this.addFall(fall);
			}

			else if (brick.getCode() == Hero.getCODE()) {
				IMobile hero = new Hero(brick.getX(), brick.getY(), this);
				setOnTheMapXY((IElement) hero, brick.getX(), brick.getY());
				setMyCharacter(hero);
			}

			else {

				setOnTheMapXY(MotionLessElementFactory.createAir(), brick.getX(), brick.getY());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getWidth()
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * The setter of the width of the map
	 * 
	 * @param width
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getHeight()
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * The setter of the height of the map
	 * 
	 * @param height
	 */
	private void setHeight(int height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getOnTheMapXY(int, int)
	 */
	@Override
	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#setOnTheMapXY(model.IElement, int, int)
	 */
	@Override
	public void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#setMapHasChanged()
	 */
	@Override
	public void setMapHasChanged() {
		this.model.setModelChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this.model.getObservable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getMyCharacter()
	 */
	@Override
	public IMobile getMyCharacter() {
		return this.myCharacter;
	}

	/**
	 * The setter of the character, the Hero
	 * 
	 * @param myCharacter
	 */
	private void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getMobs()
	 */
	@Override
	public ArrayList<IMob> getMobs() {
		return this.mobs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#addMob(model.IMob)
	 */
	@Override
	public void addMob(IMob mob) {
		this.getMobs().add(mob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeMob(model.IMob)
	 */
	@Override
	public void removeMob(IMob mob) {
		this.getMobs().remove(mob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getFalls()
	 */
	@Override
	public ArrayList<IFall> getFalls() {
		return this.falls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#addFall(model.IFall)
	 */
	@Override
	public void addFall(IFall fall) {
		this.getFalls().add(fall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeFall(model.IFall)
	 */
	@Override
	public void removeFall(IFall fall) {
		this.getFalls().remove(fall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveDown(model.IMobile)
	 */
	public boolean moveDown(IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();
		boolean result = false;

		mobile.setDirection(Direction.DOWN);

		switch (isPassing(x, y + 1, ((IElement) mobile).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y + 1)).setY(y + 1);

			result = true;
			break;
		case DIE:
			this.die(mobile);
			break;
		case PUSH:
			/*
			 * if (this.moveDown((IFall) this.getOnTheMapXY(x, y + 1))) {
			 * this.moveDown(mobile); }
			 * 
			 * result = true;
			 */ // IMPOSSIBLE MOVE
			break;
		case COLLECT:
			this.model.getCounter().addPoint(100);
			this.model.getCounter().removeOneDiamond();
			this.removeFall((IFall) this.getOnTheMapXY(x, y + 1));

			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y + 1)).setY(y + 1);

			result = true;
			break;
		case ESCAPE:
			if (model.getCounter().getDiamondLeft() == 0) {
				model.setWin(true);
			}
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveUp(model.IMobile)
	 */
	public boolean moveUp(IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();
		boolean result = false;

		mobile.setDirection(Direction.UP);

		switch (isPassing(x, y - 1, ((IElement) mobile).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y - 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y - 1)).setY(y - 1);

			result = true;
			break;
		case DIE:
			this.die(mobile);
			break;
		case PUSH:
			/*
			 * if (this.moveUp((IFall) this.getOnTheMapXY(x, y + 1))) {
			 * this.moveUp(mobile); }
			 * 
			 * result = true;
			 */ // IMPOSSIBLE MOVE
			break;
		case COLLECT:
			this.model.getCounter().addPoint(100);
			this.model.getCounter().removeOneDiamond();
			this.removeFall((IFall) this.getOnTheMapXY(x, y - 1));

			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y - 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y - 1)).setY(y - 1);

			result = true;
			break;
		case ESCAPE:
			if (model.getCounter().getDiamondLeft() == 0) {
				model.setWin(true);
			}
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveRight(model.IMobile)
	 */
	public boolean moveRight(IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();
		boolean result = false;

		mobile.setDirection(Direction.RIGHT);

		switch (isPassing(x + 1, y, ((IElement) mobile).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x + 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x + 1, y)).setX(x + 1);

			result = true;
			break;
		case DIE:
			this.die(mobile);
			break;
		case PUSH:
			if (this.moveRight((IFall) this.getOnTheMapXY(x + 1, y))) {
				this.moveRight(mobile);
			}

			result = true;
			break;
		case COLLECT:
			this.model.getCounter().addPoint(100);
			this.model.getCounter().removeOneDiamond();
			this.removeFall((IFall) this.getOnTheMapXY(x + 1, y));

			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x + 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x + 1, y)).setX(x + 1);

			result = true;
			break;
		case ESCAPE:
			if (model.getCounter().getDiamondLeft() == 0) {
				model.setWin(true);
			}
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveLeft(model.IMobile)
	 */
	public boolean moveLeft(IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();
		boolean result = false;

		mobile.setDirection(Direction.LEFT);

		switch (isPassing(x - 1, y, ((IElement) mobile).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x - 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x - 1, y)).setX(x - 1);

			result = true;
			break;
		case DIE:
			this.die(mobile);
			break;
		case PUSH:
			if (this.moveLeft((IFall) this.getOnTheMapXY(x - 1, y))) {
				this.moveLeft(mobile);
			}

			result = true;
			break;
		case COLLECT:
			this.model.getCounter().addPoint(100);
			this.model.getCounter().removeOneDiamond();
			this.removeFall((IFall) this.getOnTheMapXY(x - 1, y));

			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x - 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x - 1, y)).setX(x - 1);

			result = true;
			break;
		case ESCAPE:
			if (model.getCounter().getDiamondLeft() == 0) {
				model.setWin(true);
			}
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/**
	 * Tell how will be an element of the given type at the given coordinate
	 * 
	 * @param x
	 * @param y
	 * @param elementType
	 * @return passingState
	 */
	private PassingState isPassing(int x, int y, ElementType elementType) {
		PassingState result = PassingState.BLOCK;

		if (elementType == ElementType.MONTIONLESS) {
			// never has to happen
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.PENETRABLE) {
			result = PassingState.PASS;
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.BREAKABLE
				&& elementType == ElementType.HERO) {
			result = PassingState.PASS;
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.LIVING
				&& elementType == ElementType.HERO) {
			result = PassingState.DIE;
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.COLLECTABLE
				&& elementType == ElementType.HERO) {
			result = PassingState.COLLECT;
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.PUSHABLE
				&& elementType == ElementType.HERO) {
			result = PassingState.PUSH;
		} else if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.ENTRY
				&& elementType == ElementType.HERO) {
			result = PassingState.ESCAPE;
		} else if (this.getOnTheMapXY(x, y).getElementType() == ElementType.HERO && elementType == ElementType.MOB) {
			result = PassingState.DIE;
		} else {
			result = PassingState.BLOCK;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveDown(model.IFall)
	 */
	public boolean moveDown(IFall fall) {
		int x = fall.getX();
		int y = fall.getY();
		boolean result = false;

		if (this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IFall) this.getOnTheMapXY(x, y + 1)).setY(y + 1);
			result = true;

			if (this.getOnTheMapXY(x, y + 2).getPermeability() == Permeability.LIVING) {
				((IMobile) this.getOnTheMapXY(x, y + 2)).die();
			}
		} else if (this.getOnTheMapXY(x, y + 1).getElementType() == ElementType.MOB) {
			((IMobile) this.getOnTheMapXY(x, y + 1)).die();
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveRight(model.IFall)
	 */
	public boolean moveRight(IFall fall) {
		int x = fall.getX();
		int y = fall.getY();
		boolean result = false;

		if (this.getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x + 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IFall) this.getOnTheMapXY(x + 1, y)).setX(x + 1);
			result = true;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveLeft(model.IFall)
	 */
	public boolean moveLeft(IFall fall) {
		int x = fall.getX();
		int y = fall.getY();
		boolean result = false;

		if (this.getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x - 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IFall) this.getOnTheMapXY(x - 1, y)).setX(x - 1);
			result = true;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#die(model.IMobile)
	 */
	public void die(IMobile mobile) {
		mobile.die();
		if (((IElement) mobile).getElementType() == ElementType.MOB) {
			this.explosion(((IMob) mobile).isDroppable(), mobile);

			this.model.getCounter().addPoint(((IMob) mobile).getValue());
		} else if (((IElement) mobile).getElementType() == ElementType.HERO) {
			this.explosion(false, mobile);
		}

		this.setMapHasChanged();

	}

	/**
	 * Generate air if setDiamond is false and diamonds if true in the blast
	 * area of the given mobile
	 * 
	 * @param setDiamond
	 * @param mobile
	 */
	private void explosion(boolean setDiamond, IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();

		for (int i = 1; i > -2; i--) {
			for (int j = 1; j > -2; j--) {
				if (this.getOnTheMapXY(x + i, y + j).getPermeability() != Permeability.UNBREAKABLE
						&& this.getOnTheMapXY(x + i, y + j).getPermeability() != Permeability.ENTRY) {

					if (this.getOnTheMapXY(x + i, y + j).getElementType() == ElementType.FALL) {
						this.removeFall((IFall) this.getOnTheMapXY(x + i, y + j));
					}

					if (this.getOnTheMapXY(x + i, y + j).getPermeability() == Permeability.LIVING) {
						((IMobile) getOnTheMapXY(x + i, y + j)).die();
					}

					if (setDiamond) {
						IFall fall = FallFactory.createDiamond(x + i, y + j, this);
						setOnTheMapXY((IElement) fall, x + i, y + j);
						this.addFall(fall);
					} else {
						this.setOnTheMapXY(MotionLessElementFactory.createAir(), x + i, y + j);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveDown(model.IMob)
	 */
	public boolean moveDown(IMob mob) {
		int x = mob.getX();
		int y = mob.getY();
		boolean result = false;

		mob.setDirection(Direction.DOWN);

		switch (isPassing(x, y + 1, ((IElement) mob).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y + 1)).setY(y + 1);

			result = true;
			break;
		case DIE:
			this.die(mob);
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveUp(model.IMob)
	 */
	public boolean moveUp(IMob mob) {
		int x = mob.getX();
		int y = mob.getY();
		boolean result = false;

		mob.setDirection(Direction.UP);

		switch (isPassing(x, y - 1, ((IElement) mob).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y - 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y - 1)).setY(y - 1);

			result = true;
			break;
		case DIE:
			this.die(mob);
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveRight(model.IMob)
	 */
	public boolean moveRight(IMob mob) {
		int x = mob.getX();
		int y = mob.getY();
		boolean result = false;

		mob.setDirection(Direction.RIGHT);

		switch (isPassing(x + 1, y, ((IElement) mob).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x + 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x + 1, y)).setX(x + 1);

			result = true;
			break;
		case DIE:
			this.die(mob);
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#moveLeft(model.IMob)
	 */
	public boolean moveLeft(IMob mob) {
		int x = mob.getX();
		int y = mob.getY();
		boolean result = false;

		mob.setDirection(Direction.LEFT);

		switch (isPassing(x - 1, y, ((IElement) mob).getElementType())) {
		case PASS:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x - 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x - 1, y)).setX(x - 1);

			result = true;
			break;
		case DIE:
			this.die(mob);
			break;
		default:
			break;
		}

		this.setMapHasChanged();
		return result;
	}
}
