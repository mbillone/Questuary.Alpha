package controller;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import view.View;
import model.Model;

public class Controller{
	Model model;
	View view;
	JFrame frame;
	Timer timer;
	ArrayList<Integer> keys = new ArrayList();
	
	//*************
	//Constructor
	public Controller(){
		//create the Model and View
		model = new Model();
		view = new View();
		
		//get the ground from model
		view.setGroundImage(model.getGround());
		
		view.setPlatformImage(model.getPlatform());
		//update the view of the player's location
		view.updateView(model.getPlayerX(), model.getPlayerY(),model.getPlayerDirection(), model.getPlayerCharacter());
		
		//set the frame to add on key event listeners
		frame = view.getFrame();
		
		//add KeyListeners
		frame.addKeyListener(new ArrowKeyListener());
		
		timer = new Timer(45, new UpdateView());
		timer.start();
		
	}
	//******************************
	
	
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
					if (!model.getChangeCharacterMode()) {
						switch (keys.get(0)) {
						case (KeyEvent.VK_RIGHT):
							// if x is less than the xBoundary then increment by xVelocity
							//make player go right in model
							model.changeRoom();
							model.playerMoveRight();
							view.setAnimation(true);
							System.out.println("(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getPlayerDirectionString());
							break;
						case (KeyEvent.VK_LEFT):
							//make player go left in model
							
							model.playerMoveLeft();
							view.setAnimation(true);
							System.out.println("(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getPlayerDirectionString());
							break;
						case (KeyEvent.VK_UP):
							if(!(model.isPlayerFalling()))
							{
								model.makePlayerJump();
								System.out.println("makePlayerJump is executed");
							}
							System.out.println("Up key is pressed");
							System.out.println("(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getPlayerDirectionString());
							break;
						/*case (KeyEvent.VK_DOWN):
							if((model.isPlayerFalling()))
							{
								model.makePlayerJump();
								System.out.println("makePlayerJump is executed");
							}
							System.out.println("Up key is pressed");
							System.out.println("(" + model.getPlayerX() + "," + model.getPlayerY() + ")" + model.getPlayerDirectionString());
							break;*/
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
							model.incrementChangeCharacterCount();
							view.updateView(model.getPlayerX(), model.getPlayerY(), model.getPlayerDirection(), model.getPlayerCharacter());
							break;
						case (KeyEvent.VK_LEFT):
							// increment the player selector loop
							model.decrementChangeCharacterCount();
							view.updateView(model.getPlayerX(), model.getPlayerY(), model.getPlayerDirection(), model.getPlayerCharacter());
							break;
						}
					}
					
				}// if more then 1 key is pressed
				else if(keys.contains(KeyEvent.VK_DOWN) && keys.contains(KeyEvent.VK_RIGHT)) {
					//System.exit(0);
					// changes game mode to switching player
					model.setChangePlayerMode();
				}
				else if (keys.contains(KeyEvent.VK_UP) && keys.contains(KeyEvent.VK_RIGHT)) {
					model.changeRoom();
					model.playerMoveRight();
					if(!(model.isPlayerFalling()))
					{
						model.makePlayerJump();
						System.out.println("makePlayerJump is executed");
					}
					
				}

			}

			public void keyTyped(KeyEvent e) {
				
			}

			public void keyReleased(KeyEvent e) {
				// removes key code from arrayList once released
				if(keys.contains(e.getKeyCode())){
			        keys.remove(keys.indexOf(e.getKeyCode()));
			    }
			    switch(e.getKeyCode())
				{
					//when right arrow is released the dx is 0
					case (KeyEvent.VK_RIGHT):
						model.setPlayerDxOff();
						view.setAnimation(false);
						System.out.println("Right key is released");
						break;
					case (KeyEvent.VK_LEFT):
						//make player go left in model
						model.setPlayerDxOff();
						view.setAnimation(false);
						System.out.println("Left key is released");	
						break;
				}



			}
	}	
	
	public class UpdateView implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//test the player on falling and jumping
			model.gravity();
			model.checkCollision();
			//increment the player's x and y
			model.movePlayer();
			view.setPicNum();
			//update the view and draw the image
			view.updateView(model.getPlayerX(), model.getPlayerY(),model.getPlayerDirection(),model.getPlayerCharacter());
			view.setPlatformImage(model.getPlatform());
		}
		
	}
	
	//main class
	public static void main(String[] args){
		System.out.println("Hello World");
		Controller controller = new Controller();
	}
	
	
	
	
	
}
