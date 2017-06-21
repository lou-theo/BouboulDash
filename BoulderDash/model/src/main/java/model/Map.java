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

public class Map extends Observable implements IMap {
	private int width;
	private int height;
	private IElement[][] onTheMap;
	private ArrayList<IFall> falls = new ArrayList<IFall>();
	private ArrayList<IMob> mobs = new ArrayList<IMob>();
	private IMobile myCharacter;
	private IModel model;

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
	 * @see model.IMap#setOnTheMapXY(model.element.IElement, int, int)
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
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
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
	 * @see model.IMap#addMob(model.element.mobile.mob.IMob)
	 */
	@Override
	public void addMob(IMob mob) {
		this.getMobs().add(mob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeMob(model.element.mobile.mob.IMob)
	 */
	@Override
	public void removeMob(IMob mob) {
		this.getMobs().remove(mob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeMob(int, int)
	 */
	@Override
	public void removeMob(int x, int y) {
		// A FAIRE
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
	 * @see model.IMap#addFall(model.element.fall.IFall)
	 */
	@Override
	public void addFall(IFall fall) {
		this.falls.add(fall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeFall(model.element.fall.IFall)
	 */
	@Override
	public void removeFall(IFall fall) {
		this.getFalls().remove(fall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#removeFall(int, int)
	 */
	@Override
	public void removeFall(int x, int y) {
		// A FAIRE
	}

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
			/*if (this.moveDown((IFall) this.getOnTheMapXY(x, y + 1))) {
				this.moveDown(mobile);
			}
			
			result = true;*/ //IMPOSSIBLE MOVE
			break;
		case COLLECT:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y + 1)).setY(y + 1);
			
			model.getCounter().addPoint(100);
			model.getCounter().removeOneDiamond();
			
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
			/*if (this.moveUp((IFall) this.getOnTheMapXY(x, y + 1))) {
				this.moveUp(mobile);
			}
			
			result = true;*/ //IMPOSSIBLE MOVE
			break;
		case COLLECT:
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y - 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x, y - 1)).setY(y - 1);
			
			model.getCounter().addPoint(100);
			model.getCounter().removeOneDiamond();
			
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
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x + 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x + 1, y)).setX(x + 1);
			
			model.getCounter().addPoint(100);
			model.getCounter().removeOneDiamond();
			
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

	public boolean moveLeft(IMobile mobile) {
		int x = mobile.getX();
		int y = mobile.getY();
		boolean result = false;
		
		mobile.setDirection(Direction.RIGHT);

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
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x - 1, y);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IMobile) this.getOnTheMapXY(x - 1, y)).setX(x - 1);
			
			model.getCounter().addPoint(100);
			model.getCounter().removeOneDiamond();
			
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
		} else {
			result = PassingState.BLOCK;
		}

		return result;
	}

	public boolean moveDown(IFall fall) {
		int x = fall.getX();
		int y = fall.getY();
		boolean result = false;

		if (this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
			this.setOnTheMapXY(this.getOnTheMapXY(x, y), x, y + 1);
			this.setOnTheMapXY(MotionLessElementFactory.createAir(), x, y);
			((IFall) this.getOnTheMapXY(x, y + 1)).setY(y + 1);
			result = true;
		}

		this.setMapHasChanged();
		return result;
	}
	
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
	
	private void die(IMobile mobile) {
		
	}
}
