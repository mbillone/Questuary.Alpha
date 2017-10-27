package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Model;
import view.View;

public class Controller {
	Model model;
	View view;
	JFrame frame;
	ArrayList<Integer> keys=new ArrayList();
	

	public Controller() {
		model = new Model();
		view = new View(model.getXBoundary(), model.getYBoundary(),model.getPlayerCharacter());
		view.setGroundImage(model.getGround());
		view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection(),model.getPlayerCharacter());
		frame = view.getFrame();

		// add KeyListeners
		frame.addKeyListener(new ArrowKeyListener());
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		Controller controller = new Controller();
		/*
		 * for(int i = 0; i < 1000; i++) {
		 * 		view.updateView(model.getPlayerX(),
		 * 		model.getPlayerY()); 
		 * 		try { 
		 * 			Thread.sleep(100);
		 * 		 } catch (InterruptedException e) { 
		 * 			e.printStackTrace(); } 
		 * }
		 */
	}
	
	// KeyListener class
	public class ArrowKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			// add key code in arrayList if pressed and not already there
			if(!keys.contains(e.getKeyCode())){
		        keys.add(e.getKeyCode());
		    }
			// if only 1 key is pressed 
			if (keys.size() == 1) {
				// checks if game is not in Change player mode
				if (!model.getChangePlayerMode()) {
					switch (keys.get(0)) {
					case (KeyEvent.VK_RIGHT):
						// if x is less than the xBoundary then increment by xVelocity
						if (model.getPlayerX() < model.getXBoundary()) {
							// change in the model
							model.incrementX();
							model.setDirection(1);
							view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection(), model.getPlayerCharacter());
							System.out.println(
									"(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getDirectState());
						}
						break;
					case (KeyEvent.VK_LEFT):
						// if x is greater than zero then decrement by xVelocity
						if (model.getPlayerX() > 0) {
							// change in player
							model.decrementX();
							model.setDirection(0);
							view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection(), model.getPlayerCharacter());
							System.out.println(
									"(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getDirectState());
						}
						break;
					case (KeyEvent.VK_DOWN):
						// if q is press then quit
						//System.exit(0);
						break;
					case (KeyEvent.VK_Q):
						// if q is press then quit
						System.exit(0);
						break;
					}
				}else {
					// game is in change player mode 
					switch (keys.get(0)) {
					case (KeyEvent.VK_RIGHT):
						// increment the player selector loop
						model.incrementChangePlayerCount();
						view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection(), model.getPlayerCharacter());
						break;
					case (KeyEvent.VK_LEFT):
						// increment the player selector loop
						model.incrementChangePlayerCount();
						view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection(), model.getPlayerCharacter());
						break;
					}
				}
				
			}// if more then 1 key is pressed
			else if(keys.contains(KeyEvent.VK_DOWN) & keys.contains(KeyEvent.VK_RIGHT)) {
				//System.exit(0);
				// changes game mode to switching player
				model.setChangePlayerMode();
			}

		}

		public void keyTyped(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			// removes key code from arrayList once released
			if(keys.contains(e.getKeyCode())){
		        keys.remove(keys.indexOf(e.getKeyCode()));
		    }

		}
	}

}
