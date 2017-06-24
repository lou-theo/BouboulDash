package view.gameframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class GameFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = -4530935869966255122L;
	private GamePanel pan;
	private IEventPerformer eventPerformer;
	
	/**
	 * The constructor of the GameFrame
	 * Creates a window and its gamePanel
	 * @param eventPerformer
	 * @param graphicsBuilder
	 */
	public GameFrame(IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder) {
		this.setEventPerformer(eventPerformer);
		
		this.setTitle("An amazing Game");
	    this.setSize(graphicsBuilder.getGlobalWidth(), graphicsBuilder.getGlobalHeight());
	    this.setLocationRelativeTo(null);               
	 
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    this.setResizable(false);
	    
	   
	    this.pan = new GamePanel(graphicsBuilder);
	    
	    
	    this.setContentPane(pan);
	    this.setVisible(true);
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.getEventPerformer().eventPerform(e);
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * The getter of the gamePanel
	 * @return pan, the gamePanel
	 */
	public GamePanel getPan() {
		return pan;
	}

	/**
	 * The setter of the gamePanel
	 * @param pan, the gamePanel
	 */
	public void setPan(GamePanel pan) {
		this.pan = pan;
	}

	/**
	 * The getter of the eventPerformer (the view)
	 * @return
	 */
	public IEventPerformer getEventPerformer() {
		return eventPerformer;
	}

	/**
	 * The setter of the eventPerformer (the view)
	 * @param eventPerformer
	 */
	public void setEventPerformer(IEventPerformer eventPerformer) {
		this.eventPerformer = eventPerformer;
	}
}
