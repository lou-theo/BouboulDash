package controller;

import model.Direction;
import model.IFall;
import model.IMob;
import model.IModel;
import model.Permeability;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {

	private static int TIME_SLEEP = 100;
	private IModel model;
	private IView view;
	private UserOrder stackOrder;

	/**
	 * The ModelFacade constructor
	 * 
	 * @param model
	 * @param view
	 */
	public ControllerFacade(IModel model, IView view) {
		this.setModel(model);
		this.setView(view);
		this.clearStackOrder();
	}

	/**
	 * The getter of the model
	 * 
	 * @return model
	 */
	private IModel getModel() {
		return model;
	}

	/**
	 * The setter of the model
	 * 
	 * @param model
	 */
	private void setModel(IModel model) {
		this.model = model;
	}

	/**
	 * the getter of the view
	 * 
	 * @return view
	 */
	private IView getView() {
		return view;
	}

	/**
	 * The setter of the view
	 * 
	 * @param view
	 */
	private void setView(IView view) {
		this.view = view;
	}

	/**
	 * The setter of the stack order. The stack order stock the last order of
	 * the user
	 * 
	 * @param stackOrder
	 */
	private void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * The getter of the stackOrder
	 * 
	 * @return stackOrder
	 */
	private UserOrder getStackOrder() {
		return stackOrder;
	}

	/**
	 * Set to "NOP" the current stackOrder
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IController#play()
	 */
	@Override
	public void play() throws InterruptedException {
		while (this.getModel().getMap().getMyCharacter().isAlive() == true
				&& this.getModel().getTimer().isTimeAway() == false && this.getModel().isWin() == false) {
			this.gameLoop();
		}
		this.getModel().getTimer().setGameFinished(true);

		if (this.getModel().isWin()) {
			this.getView().displayMessage("You Win !\nYou're so strong !");
		} else {
			this.getView().displayMessage("You are dead...\nTry again !");
		}

		this.getView().closeAll();
	}

	/**
	 * Launch by play method, run while the loop of the game didn't stop Makes
	 * move the different elements which are able to move one per one
	 * 
	 * @throws InterruptedException
	 */
	private void gameLoop() throws InterruptedException {
		Thread.sleep(TIME_SLEEP);

		this.moveHero();

		for (IFall fall : this.getModel().getMap().getFalls()) {
			this.moveFall(fall);
		}

		/*for (IMob mob : this.getModel().getMap().getMobs()) {
			if (mob.isAlive() == false) {
				this.getModel().getMap().die(mob);
				this.getModel().getMap().removeMob(mob);
			}
		}*/
		
		for (int i = 0; i < this.getModel().getMap().getMobs().size(); i++) {
			if (this.getModel().getMap().getMobs().get(i).isAlive() == false) {
				this.getModel().getMap().die(this.getModel().getMap().getMobs().get(i));
				this.getModel().getMap().removeMob(this.getModel().getMap().getMobs().get(i));
			}
		}

		for (IMob mob : this.getModel().getMap().getMobs()) {
			if (mob.isAlive()) {
				this.moveMob(mob);
			}
		}

		if (this.getModel().getMap().getMyCharacter().isAlive() == false) {
			this.getModel().getMap().die(this.getModel().getMap().getMyCharacter());
		}

	}

	/**
	 * Move the Hero according to the StackOrder and the clear the stackOrder
	 */
	public void moveHero() {
		switch (this.getStackOrder()) {
		case DOWN:
			this.getModel().getMap().moveDown(this.getModel().getMap().getMyCharacter());
			break;
		case UP:
			this.getModel().getMap().moveUp(this.getModel().getMap().getMyCharacter());
			break;
		case RIGHT:
			this.getModel().getMap().moveRight(this.getModel().getMap().getMyCharacter());
			break;
		case LEFT:
			this.getModel().getMap().moveLeft(this.getModel().getMap().getMyCharacter());
			break;
		case SUICIDE:
			this.getModel().getMap().getMyCharacter().die();
			break;
		default:
			break;
		}

		this.clearStackOrder();
	}

	/**
	 * Move the given mob according to his direction
	 * 
	 * @param mob
	 */
	public void moveMob(IMob mob) {
		switch (mob.getDirection()) {
		case DOWN:
			if (this.getModel().getMap().moveDown(mob) == false) {
				mob.setDirection(Direction.RIGHT);
			}
			break;
		case RIGHT:
			if (this.getModel().getMap().moveRight(mob) == false) {
				mob.setDirection(Direction.UP);
			}
			break;
		case UP:
			if (this.getModel().getMap().moveUp(mob) == false) {
				mob.setDirection(Direction.LEFT);
			}
			break;
		case LEFT:
			if (this.getModel().getMap().moveLeft(mob) == false) {
				mob.setDirection(Direction.DOWN);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Try to make fall the given fall element (a diamond or a rock)
	 * 
	 * @param fall
	 */
	public void moveFall(IFall fall) {
		if (this.getModel().getMap().moveDown(fall)) {

		} else if (this.getModel().getMap().getOnTheMapXY(fall.getX() - 1, fall.getY() + 1)
				.getPermeability() == Permeability.PENETRABLE
				&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
						.getPermeability() != Permeability.BREAKABLE
				&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
						.getPermeability() != Permeability.LIVING) {
			if (this.getModel().getMap().moveLeft(fall)) {

			} else if (this.getModel().getMap().getOnTheMapXY(fall.getX() + 1, fall.getY() + 1)
					.getPermeability() == Permeability.PENETRABLE
					&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
							.getPermeability() != Permeability.BREAKABLE
					&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
							.getPermeability() != Permeability.LIVING) {
				this.getModel().getMap().moveRight(fall);
			}
		} else if (this.getModel().getMap().getOnTheMapXY(fall.getX() + 1, fall.getY() + 1)
				.getPermeability() == Permeability.PENETRABLE
				&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
						.getPermeability() != Permeability.BREAKABLE
				&& this.getModel().getMap().getOnTheMapXY(fall.getX(), fall.getY() + 1)
						.getPermeability() != Permeability.LIVING) {
			this.getModel().getMap().moveRight(fall);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IOrderPerformer#orderPerform(controller.UserOrder)
	 */
	@Override
	public void orderPerform(UserOrder userOrder) {
		this.setStackOrder(userOrder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IController#getOrderPerformer()
	 */
	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
