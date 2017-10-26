package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import model.Model;
import view.View;

public class Controller {
	Model model;
	View view;
	JFrame frame;

	public Controller() {
		model = new Model();
		view = new View(model.getXBoundary(), model.getYBoundary());
		view.setGroundImage(model.getGround());
		view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection());
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
			switch (e.getKeyCode()) {
			case (KeyEvent.VK_RIGHT):
				// if x is less than the xBoundary then increment by xVelocity
				if (model.getPlayerX() < model.getXBoundary()) {
					// change in the model
					model.incrementX();
					model.setDirection(1);
					view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection());
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
					view.updateView(model.getPlayerX(), model.getPlayerY(), model.getDirection());
					System.out.println(
							"(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getDirectState());
				}
				break;

			case (KeyEvent.VK_Q):
				// if q is press then quit
				System.exit(0);
				break;
			}

		}

		public void keyTyped(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
