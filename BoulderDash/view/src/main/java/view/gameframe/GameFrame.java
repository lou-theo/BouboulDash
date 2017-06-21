package view.gameframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4530935869966255122L;
	private GamePanel pan;
	private IEventPerformer eventPerformer;
	
	public GameFrame(IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder) {
		this.setEventPerformer(eventPerformer);
		
		this.setTitle("An amazing Game");
	    this.setSize(graphicsBuilder.getGlobalHeight(), graphicsBuilder.getGlobalWidth());
	    this.setLocationRelativeTo(null);               
	 
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    this.setResizable(false);
	    this.pan = new GamePanel(graphicsBuilder);
	    
	    this.setContentPane(pan);               
	    this.setVisible(true);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		this.getEventPerformer().eventPerform(e);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public GamePanel getPan() {
		return pan;
	}

	public void setPan(GamePanel pan) {
		this.pan = pan;
	}

	public IEventPerformer getEventPerformer() {
		return eventPerformer;
	}

	public void setEventPerformer(IEventPerformer eventPerformer) {
		this.eventPerformer = eventPerformer;
	}
}
