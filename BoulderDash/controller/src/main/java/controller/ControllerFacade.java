package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {

	private static int TIME_SLEEP = 500;
	private IModel model;
	private IView view;
	private UserOrder stackOrder;

	public ControllerFacade(IModel model,IView view) {
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

	private void gameLoop() throws InterruptedException{
		Thread.sleep(TIME_SLEEP);
		
		switch (this.getStackOrder()) {
		case DOWN:
			this.getModel().getMap().getMyCharacter().moveDown();
			break;
		case UP:
			this.getModel().getMap().getMyCharacter().moveUp();
			break;
		case RIGHT:
			this.getModel().getMap().getMyCharacter().moveRight();
			break;
		case LEFT:
			this.getModel().getMap().getMyCharacter().moveLeft();
			break;
		default:
			break;
		}

		this.clearStackOrder();
	}

	public void moveMob() {
		
		
	}
	
	public void moveFall() {
		
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
