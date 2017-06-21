package view.gameframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4530935869966255122L;
	private JPanel pan;
	private IEventPerformer eventPerformer;
	
	public GameFrame(IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public JPanel getPan() {
		return pan;
	}

	public void setPan(JPanel pan) {
		this.pan = pan;
	}

	public IEventPerformer getEventPerformer() {
		return eventPerformer;
	}

	public void setEventPerformer(IEventPerformer eventPerformer) {
		this.eventPerformer = eventPerformer;
	}
}
