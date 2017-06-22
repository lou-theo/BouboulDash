package view.gameframe;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4530935869966255122L;
	private GamePanel pan;
	private GamePanel counterPan;
	private GamePanel timerPan;
	private IEventPerformer eventPerformer;
	
	public GameFrame(IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder) {
		this.setEventPerformer(eventPerformer);
		
		this.setTitle("An amazing Game");
	    this.setSize(graphicsBuilder.getGlobalWidth(), graphicsBuilder.getGlobalHeight());
	    this.setLocationRelativeTo(null);               
	 
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    this.setResizable(false);
	    
	    JPanel b1 = new JPanel();
	    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    this.counterPan = new GamePanel(graphicsBuilder);
	    this.counterPan.setBackground(Color.BLUE);
	    b1.add(this.counterPan);
	    this.timerPan = new GamePanel(graphicsBuilder);
	    this.timerPan.setBackground(Color.RED);
	    b1.add(this.timerPan);
	    
	    
	    this.pan = new GamePanel(graphicsBuilder);
	    
	    
	    JPanel b4 = new JPanel();
	    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
	    b4.add(b1);
	    b4.add(this.pan);
	    
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

	public GamePanel getCounterPan() {
		return counterPan;
	}

	public void setCounterPan(GamePanel counterPan) {
		this.counterPan = counterPan;
	}

	public GamePanel getTimerPan() {
		return timerPan;
	}

	public void setTimerPan(GamePanel timerPan) {
		this.timerPan = timerPan;
	}
}
