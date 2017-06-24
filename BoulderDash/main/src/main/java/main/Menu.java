package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
import model.dao.MapDAO;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Menu.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Menu extends Thread implements ActionListener  {
	
	private JFrame fen = new JFrame();
	private JComboBox<Integer> combo = new JComboBox<Integer>();
	private JButton button = new JButton("Play !");
	private MenuPanel pan = new MenuPanel();
	
	private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private int height = (int)dimension.getHeight();
	private int width  = (int)dimension.getWidth();
	private int menuHeight = 587;
	private int menuWidth = 455;
	
	public Menu() throws SQLException {
		fen.setTitle("BouBoul Dash");
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fen.setContentPane(pan);
		fen.setLayout(null);
		
		fen.setLocation((width - menuWidth) / 2, (height - menuHeight) / 2);;
		fen.setSize(menuWidth, menuHeight);
		fen.setResizable(false);
		
		ArrayList<Integer> levels = MapDAO.getAllLevels();
		for (Integer integer : levels) {
			combo.addItem(integer);
		}
		
		button.addActionListener(this);
		
		
		fen.add(combo);
	    fen.add(button);
	    button.setBounds(320, 500, 110, 50);
	    combo.setBounds(140, 500, 150, 50);
	    fen.setVisible(true);
	    
	    new MenuMusic("music/theme.wav");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fen.setVisible(false);
		this.start();
	}

	@Override
	public void run() {
		IModel model;
		IView view;
		IController controller;
		try {
			model = new ModelFacade((int) combo.getSelectedItem());
			view = new ViewFacade(model);
			controller = new ControllerFacade(model, view);
			view.setOrderPerformer(controller.getOrderPerformer());

			controller.play();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}