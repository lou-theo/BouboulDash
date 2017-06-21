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
	private ArrayList<IFall> falls;
	private ArrayList<IMob> mobs;
	private IMobile myCharacter;

	public Map(int level) {
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

		this.onTheMap = new IElement[MapDAO.getWidth(level)][MapDAO.getHeight(level)];
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
		this.getFalls().add(fall);
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
}
