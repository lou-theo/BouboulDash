package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Direction;
import model.ElementType;
import model.IElement;
import model.IMobile;
import model.IModel;
import view.gameframe.IGraphicsBuilder;

/**
 * <h1>The Class GraphicsBuilder draws all the graphics in the panel.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class GraphicsBuilder implements IGraphicsBuilder {


	private IModel model;
	private int squareSize = 32;
	private int globalHeight;
	private int globalWidth;
	private int displayHeight = 50;

	/**
	 * The constructor of GraphicsBuilder
	 * @param model
	 */
	public GraphicsBuilder(IModel model) {
		this.setModel(model);
		this.globalHeight = ((this.getModel().getMap().getHeight() + 1) * this.squareSize) + displayHeight;
		this.globalWidth = ((this.getModel().getMap().getWidth() + 0) * this.squareSize);
	}

	/* (non-Javadoc)
	 * @see view.gameframe.IGraphicsBuilder#applyModelToGraphics(java.awt.Graphics)
	 */
	@Override
	public void applyModelToGraphics(Graphics graphics) {
		this.buildEmptyMap(graphics);
		this.drawElements(graphics);

	}

	/**
	 * Clear the last graphics by drawing a white rectangle which size is the same as the screen
	 * @param graphics
	 */
	private void buildEmptyMap(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, getGlobalWidth(), getGlobalHeight());
	}
	
	/**
	 * Draw the Timer on the panel
	 * @param graphics
	 */
	private void printTimer(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.drawString(this.getModel().getTimer().getTime() + " sec", 
				(globalWidth / 3) * 2, displayHeight / 2 + 5);
	}
	
	/**
	 * Draw the point counter and the number of diamonds left in the panel
	 * @param graphics
	 */
	private void printCounter(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.drawString(this.getModel().getCounter().getPoint() + " points", 
				(globalWidth / 10) * 1, (displayHeight / 3) * 1 + 5);
		graphics.drawString(this.getModel().getCounter().getDiamondLeft() + " diamonds",
				(globalWidth / 10) * 1, (displayHeight / 3) * 2 + 5);
	}

	/**
	 * Look at all the element one by one and choose and they have to be drawn
	 * @param graphics
	 */
	private void drawElements(Graphics graphics) {
		this.buildEmptyMap(graphics);

		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {

				if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.MONTIONLESS) {
					this.drawMotionLessElement(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.MOB) {
					this.drawMob(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.FALL) {
					this.drawFall(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.HERO) {
					this.drawHero(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				}

			}
			
			this.printCounter(graphics);
			this.printTimer(graphics);
		}
	}

	/**
	 * Draw a motionLess element at the given coordinate
	 * @param graphics
	 * @param element
	 * @param x
	 * @param y
	 */
	private void drawMotionLessElement(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight, null);
	}

	/**
	 * Draw a mob at the given given coordinate
	 * @param graphics
	 * @param element
	 * @param x
	 * @param y
	 */
	private void drawMob(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
				(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight,
				0 * squareSize, 0 * squareSize, (0 + 1) * squareSize, (0 + 1) * squareSize, null);
	}

	/**
	 * Draw a fall element at the given coordinate
	 * @param graphics
	 * @param element
	 * @param x
	 * @param y
	 */
	private void drawFall(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight, null);
	}

	/**
	 * Draw the hero at the given coordinate and choose which sprite has to be drawn according to the direction
	 * @param graphics
	 * @param element
	 * @param x
	 * @param y
	 */
	private void drawHero(Graphics graphics, IElement element, int x, int y) {
		if (((IMobile) element).getDirection() == Direction.NONE) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight, 0 * squareSize,
					0 * squareSize, (0 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile) element).getDirection() == Direction.UP) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight, 1 * squareSize,
					0 * squareSize, (1 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile) element).getDirection() == Direction.RIGHT) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight, 2 * squareSize,
					0 * squareSize, (2 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile) element).getDirection() == Direction.DOWN) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight, 3 * squareSize,
					0 * squareSize, (3 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile) element).getDirection() == Direction.LEFT) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize + displayHeight,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize + displayHeight, 4 * squareSize,
					0 * squareSize, (4 + 1) * squareSize, (0 + 1) * squareSize, null);
		}
	}

	/* (non-Javadoc)
	 * @see view.gameframe.IGraphicsBuilder#getGlobalWidth()
	 */
	@Override
	public int getGlobalWidth() {
		return this.globalWidth;
	}

	/* (non-Javadoc)
	 * @see view.gameframe.IGraphicsBuilder#getGlobalHeight()
	 */
	@Override
	public int getGlobalHeight() {
		return this.globalHeight;
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
}
