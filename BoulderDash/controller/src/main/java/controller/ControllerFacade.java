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
	
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	private void gameLoop(){
		
	}

	public void moveMob() {
		
		
	}
	
	public void moveFall() {
		
	}

	@Override
	public void orderPerform(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return this;
	}
}
