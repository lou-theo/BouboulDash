package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import model.dao.ElementDAO;
import model.dao.MapDAO;
import model.element.fall.Diamond;
import model.element.fall.Rock;
import model.element.mobile.Hero;
import model.element.mobile.mob.Bat;
import model.element.mobile.mob.Goblin;
import model.element.mobile.mob.Monster;
import model.element.mobile.mob.Spider;
import model.element.motionless.Air;
import model.element.motionless.Door;
import model.element.motionless.MotionLessElementFactory;
import model.element.motionless.Mud;
import model.element.motionless.SuperWall;
import model.element.motionless.Wall;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade extends Observable implements IModel {

    private ICounter counter;
    private ITimer timer;
    private IMap map;
    private boolean win = false;
    
    public ModelFacade(int level) {
    	
    	try {
			this.instantiateValues();
			this.setCounter(new Counter(MapDAO.getDiamondLeft(level), this));
			this.setTimer(new Timer(MapDAO.getTimer(level), this));
			
			this.setMap(new Map(level, this));
		} catch (SQLException e) {
			System.out.println("Error during the Model Generation");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void instantiateValues() throws SQLException, IOException {
    	Mud.setCODE(ElementDAO.getCode(Mud.getNAME()));
    	Mud.setPERMEABILITY(ElementDAO.getPermeability(Mud.getNAME()));
    	
    	Door.setCODE(ElementDAO.getCode(Door.getNAME()));
    	Door.setPERMEABILITY(ElementDAO.getPermeability(Door.getNAME()));
    	
    	SuperWall.setCODE(ElementDAO.getCode(SuperWall.getNAME()));
    	SuperWall.setPERMEABILITY(ElementDAO.getPermeability(SuperWall.getNAME()));
    	
    	Air.setCODE(ElementDAO.getCode(Air.getNAME()));
    	Air.setPERMEABILITY(ElementDAO.getPermeability(Air.getNAME()));
    	
    	Wall.setCODE(ElementDAO.getCode(Wall.getNAME()));
    	Wall.setPERMEABILITY(ElementDAO.getPermeability(Wall.getNAME()));
    	
    	
    	Diamond.setCODE(ElementDAO.getCode(Diamond.getNAME()));
    	Diamond.setPERMEABILITY(ElementDAO.getPermeability(Diamond.getNAME()));
    	
    	Rock.setCODE(ElementDAO.getCode(Rock.getNAME()));
    	Rock.setPERMEABILITY(ElementDAO.getPermeability(Rock.getNAME()));
    	
    	Goblin.setCODE(ElementDAO.getCode(Goblin.getNAME()));
    	Goblin.setDROP(ElementDAO.getDrop(Goblin.getNAME()));
    	Goblin.setVALUE(ElementDAO.getValue(Goblin.getNAME()));
    	Goblin.setPERMEABILITY(ElementDAO.getPermeability(Goblin.getNAME()));
    	
    	Monster.setCODE(ElementDAO.getCode(Monster.getNAME()));
    	Monster.setDROP(ElementDAO.getDrop(Monster.getNAME()));
    	Monster.setVALUE(ElementDAO.getValue(Monster.getNAME()));
    	Monster.setPERMEABILITY(ElementDAO.getPermeability(Monster.getNAME()));
    	
    	Bat.setCODE(ElementDAO.getCode(Bat.getNAME()));
    	Bat.setDROP(ElementDAO.getDrop(Bat.getNAME()));
    	Bat.setVALUE(ElementDAO.getValue(Bat.getNAME()));
    	Bat.setPERMEABILITY(ElementDAO.getPermeability(Bat.getNAME()));
    	
    	Spider.setCODE(ElementDAO.getCode(Spider.getNAME()));
    	Spider.setDROP(ElementDAO.getDrop(Spider.getNAME()));
    	Spider.setVALUE(ElementDAO.getValue(Spider.getNAME()));
    	Spider.setPERMEABILITY(ElementDAO.getPermeability(Spider.getNAME()));
    	

    	Hero.setCODE(ElementDAO.getCode(Hero.getNAME()));
    	Hero.setPERMEABILITY(ElementDAO.getPermeability(Hero.getNAME()));
    	
    	// In order to have some indispensable Sprite
    	MotionLessElementFactory.createAir().getSprite().loadImage();
    	Diamond.setSPRITE();
    }

	public ICounter getCounter() {
		return counter;
	}

	private void setCounter(ICounter counter) {
		this.counter = counter;
	}

	public ITimer getTimer() {
		return timer;
	}

	private void setTimer(ITimer timer) {
		this.timer = timer;
	}

	public IMap getMap() {
		return map;
	}

	private synchronized void setMap(IMap map) {
		this.map = map;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

    public void setModelChanged() {
		this.setChanged();
		this.notifyObservers();
    }
    
    public Observable getObservable() {
    	return this;
    }
}
