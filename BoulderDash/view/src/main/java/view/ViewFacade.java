package view;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IModel;
import view.gameframe.GameFrame;
import view.gameframe.IEventPerformer;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, IEventPerformer {

	private IOrderPerformer orderPerformer;
	private IModel model;
	private GameFrame gameFrame;
	private GraphicsBuilder graphicsBuilder;

	/**
	 * The constructor of ViewFacade
	 * @param model
	 * @throws IOException
	 */
	public ViewFacade(IModel model) throws IOException {
		this.setModel(model);

		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				this.getModel().getMap().getOnTheMapXY(x, y).getSprite().loadImage();
				this.getModel().getMap().getOnTheMapXY(x, y).getSprite().setImageLoaded(true);
			}
		}
		

		this.setGraphicsBuilder(new GraphicsBuilder(model));

		SwingUtilities.invokeLater(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.setGameFrame(new GameFrame(this.getEventPerformer(), this.getGraphicsBuilder()));

		this.gameFrame.addKeyListener(gameFrame);

		this.getModel().getMap().getObservable().addObserver(this.getGameFrame().getPan());
	}

	/* (non-Javadoc)
	 * @see view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);

	}

	/* (non-Javadoc)
	 * @see view.IView#closeAll()
	 */
	@Override
	public void closeAll() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see view.gameframe.IEventPerformer#eventPerform(java.awt.event.KeyEvent)
	 */
	@Override
	public void eventPerform(KeyEvent keyCode) {
		this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyCode.getKeyCode()));

	}

	/**
	 * The getter of the eventPerformer (the view)
	 * @return
	 */
	public IEventPerformer getEventPerformer() {
		return this;
	}

	/**
	 * Convert a key code from the keyboard to an order for the hero
	 * @param keyCode
	 * @return
	 */
	private UserOrder keyCodeToUserOrder(int keyCode) {
		UserOrder userOrder;

		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_A:
			userOrder = UserOrder.SUICIDE;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	/**
	 * The getter of the the OrderPerformer (the controller)
	 * @return
	 */
	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	/* (non-Javadoc)
	 * @see view.IView#setOrderPerformer(controller.IOrderPerformer)
	 */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
	 * The getter of the model
	 * @return model
	 */
	public IModel getModel() {
		return model;
	}

	/**
	 * The setter of the model
	 * @param model
	 */
	public void setModel(IModel model) {
		this.model = model;
	}

	/**
	 * The getter of the graphicsBuilder
	 * @return graphicsBuilder
	 */
	public GraphicsBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	/**
	 * The setter of the graphicsBuilder
	 * @param graphicsBuilder
	 */
	public void setGraphicsBuilder(GraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	/**
	 * The getter of the gameFrame
	 * @return gameFrame
	 */
	public GameFrame getGameFrame() {
		return gameFrame;
	}

	/**
	 * The setter of the gameFrame
	 * @param gameFrame
	 */
	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

}
