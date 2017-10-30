package model;

import java.awt.Rectangle;
import java.awt.Toolkit;

import model.sprites.dynamic.Player;
import view.View;

public class Model {

	//get the screen's dimensions
	final private static double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final private static double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	final private static double screenRatio = screenWidth/screenHeight;
	
	private static View view;
	private int xBoundary;
	private int yBoundary;
	
	//fixed gravity constant
	private int gravity = 10;
		
	private static Player player;
	private static int startingX = 0;
	private static int startingY = 500;
  
	private boolean changeCharacterMode;
	private int changeCharacterCount = 0;
	
	private static Ground ground;
	private int groundX;
	private int groundY;
	private int groundOffSet = 100;
	
	
	//************************
	//Constructor
	public Model() {
    
		int playerWidth = (int) (screenWidth * 0.1);
		int playerHeight = (int) (playerWidth * screenRatio);
		
		//set the boundaries
		xBoundary = (int)screenWidth - playerWidth;
		yBoundary = (int)screenHeight - playerHeight;
		
		//create Player object
		player = new Player(startingX, startingY, playerWidth, playerHeight, gravity);
    
		//create Ground object
		ground = new Ground(0, (int)(screenHeight - groundOffSet), (int)(screenWidth), groundOffSet);
    
		changeCharacterMode = false;
	}

	//setter for player's deltax
	public void playerMoveLeft() {
		player.setDirection(0);
		//check if player is going out of x bound
		if(player.getX() >= 0) {
			System.out.println("Boundary valid " + xBoundary);
			player.moveLeft();
			System.out.println("ground" + ground.getWidth());
		} else {
      //if out of bound then don't increment the x
			System.out.println("Boundary invalid 0");
			System.out.println("Player is out of Boundary to Left");
			player.setDeltaXOff();
		}
	}
  
	public void playerMoveRight() {
		player.setDirection(1);
		//check if player is going out of x bound
		if(player.getX() <= xBoundary) {
			System.out.println("Boundary valid " + xBoundary);
			player.moveRight();
			System.out.println("ground" + ground.getWidth());
		} else {
			System.out.println("Boundary invalid " + xBoundary);
			System.out.println("Player is out of Boundary to Right");
			player.setDeltaXOff();
		}
	}

	public void resetChangePlayerMode() {
		changeCharacterMode = !changeCharacterMode;
	}
  
	public void incrementChangeCharacterCount() {
		changeCharacterCount++;
	}
  
	public void decrementChangeCharacterCount() {
		changeCharacterCount--;
	}
	
	//getter for screenWidth
	public static int getScreenWidth() {
		return (int)screenWidth;
	}
	
	//getter for screenHeight() {
	public static int getScreenHeight() {
		return (int)screenHeight;
	}

	public static double getScreenRatio() {
		return screenRatio;
	}
	
	//getter for ground
	public Ground getGround() {
		return ground;
	}
	
	//getters for the boundaries
	public int getXBoundary() {
		return xBoundary;
	}
	public int getYBoundary() {
		return yBoundary;
	}
	
	public boolean getChangeCharacterMode() {
		return changeCharacterMode;
	}
  
	public int getChangeCharacterCount() {
		return changeCharacterCount;
	}
	
	public static int getStartingX() {
		return startingX;
	}
	
	public static int getStartingY() {
		return startingY;
	}

	public void movePlayer() {
		player.move();		
	}

	//change room player is in
	public void changeRoom(){
		if (getPlayerX() >= (xBoundary/2)) {
			player.setX(startingX);
		}
	} 
	
	public void setPlayerDeltaXOff(){
		player.setDeltaXOff();
	}

	//getters for player falling and jumping
	public boolean isPlayerJumping(){
		return player.getJumping();
	}
  
	public boolean isPlayerFalling(){
		return player.getFalling();
	}
	
	//set the player to jumping mode
	public void makePlayerJump(){
		player.setJumping();
	}
	
	//checks if it is colliding
	public void gravity(){
		player.gravityEffect(ground);
	}
	
	//getter for player's coordinates
	public double getPlayerX() {
		return player.getX();
	}
	public double getPlayerY() {
		return player.getY();
	}	
	
	//getter for player dimensions
	public double getPlayerWidth() {
		return player.getWidth();
	}
	public double getPlayerHeight() {
		return player.getHeight();
	}
	
	//getter for player's direction
	public static int getPlayerDirection() {
		return player.getDirection();
	}
  
	public String getPlayerDirectionString() {
		return player.getDirectionState();
	}
  
	public String getPlayerCharacter() {
		return player.getPlayerCharacter(changeCharacterCount);
	}
	  
}
