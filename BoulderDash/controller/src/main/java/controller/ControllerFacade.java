package controller;

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

	public ControllerFacade(IModel model, IView view) {
		this.setModel(model);
		this.setView(view);
		this.clearStackOrder();
	}

	private IModel getModel() {
		return model;
	}

	private void setModel(IModel model) {
		this.model = model;
	}

	private IView getView() {
		return view;
	}

	private void setView(IView view) {
		this.view = view;
	}

	private void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	private UserOrder getStackOrder() {
		return stackOrder;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	@Override
	public void play() throws InterruptedException {
		while (this.getModel().getMap().getMyCharacter().isAlive() == true) {
			this.gameLoop();
		}

		this.getView().closeAll();
	}

	private void gameLoop() throws InterruptedException {
		Thread.sleep(TIME_SLEEP);

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

		for (IFall fall : this.getModel().getMap().getFalls()) {
			this.moveFall(fall);
		}
		
		for (IMob mob : this.getModel().getMap().getMobs()) {
			if (mob.isAlive() == false) {
				this.getModel().getMap().die(mob);
			}
		}
		
		if (this.getModel().getMap().getMyCharacter().isAlive() == false) {
			this.getModel().getMap().die(this.getModel().getMap().getMyCharacter());
		}

		for (IMob mob : this.getModel().getMap().getMobs()) {
			if (mob.isAlive() == false) {
				this.moveMob(mob);
			}
		}
		
	}

	public void moveMob(IMob mob) {

	}

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

	@Override
	public void orderPerform(UserOrder userOrder) {
		this.setStackOrder(userOrder);
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
