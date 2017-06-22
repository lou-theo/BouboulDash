package view;

import java.awt.Graphics;

import model.Direction;
import model.ElementType;
import model.IElement;
import model.IMobile;
import model.IModel;
import view.gameframe.IGraphicsBuilder;

public class GraphicsBuilder implements IGraphicsBuilder {

	private IModel model;
	// private Image emptyMap;
	private int squareSize = 32;
	// private int imageSize = 32;
	private int globalHeight;
	private int globalWidth;
	private int displayHeight;

	public GraphicsBuilder(IModel model) {
		this.setModel(model);
		this.globalHeight = ((this.getModel().getMap().getHeight() + 0) * this.squareSize) + displayHeight;
		this.globalWidth = ((this.getModel().getMap().getWidth() + 1) * this.squareSize) + displayHeight;
	}

	@Override
	public void applyModelToGraphics(Graphics graphics) {
		this.buildEmptyMap(graphics);
		this.drawElements(graphics);

	}

	private void buildEmptyMap(Graphics graphics) {
		graphics.fillRect(0, 0, getGlobalWidth(), getGlobalHeight());
	}

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
		}
	}

	private void drawMotionLessElement(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
	}

	private void drawMob(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
				(1 + x) * this.squareSize, (1 + y) * this.squareSize, 0 * squareSize, 0 * squareSize,
				(0 + 1) * squareSize, (0 + 1) * squareSize, null);
	}

	private void drawFall(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
	}

	private void drawHero(Graphics graphics, IElement element, int x, int y) {
		if (((IMobile)element).getDirection() == Direction.NONE) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize, 0 * squareSize, 0 * squareSize,
					(0 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile)element).getDirection() == Direction.UP) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize, 1 * squareSize, 0 * squareSize,
					(1 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile)element).getDirection() == Direction.RIGHT) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize, 2 * squareSize, 0 * squareSize,
					(2 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile)element).getDirection() == Direction.DOWN) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize, 3 * squareSize, 0 * squareSize,
					(3 + 1) * squareSize, (0 + 1) * squareSize, null);
		} else if (((IMobile)element).getDirection() == Direction.LEFT) {
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize,
					(1 + x) * this.squareSize, (1 + y) * this.squareSize, 4 * squareSize, 0 * squareSize,
					(4 + 1) * squareSize, (0 + 1) * squareSize, null);
		}
	}

	@Override
	public int getGlobalWidth() {
		return this.globalWidth;
	}

	@Override
	public int getGlobalHeight() {
		return this.globalHeight;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}
}
