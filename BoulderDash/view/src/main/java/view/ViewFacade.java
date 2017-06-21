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
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, IEventPerformer {

	private IOrderPerformer orderPerformer;
	private IModel model;
	private GameFrame gameFrame;
	private GraphicsBuilder graphicsBuilder;

	public ViewFacade(IModel model) throws IOException {
		this.setModel(model);

		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				this.getModel().getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
		

		this.setGraphicsBuilder(new GraphicsBuilder(model));

		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
		this.setGameFrame(new GameFrame(this.getEventPerformer(), this.getGraphicsBuilder()));

		this.gameFrame.addKeyListener(gameFrame);

		this.getModel().getMap().getObservable().addObserver(this.getGameFrame().getPan());
	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);

	}

	@Override
	public void closeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventPerform(KeyEvent keyCode) {
		this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyCode.getKeyCode()));

	}

	public IEventPerformer getEventPerformer() {
		return this;
	}

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

	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public GraphicsBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	public void setGraphicsBuilder(GraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

}
