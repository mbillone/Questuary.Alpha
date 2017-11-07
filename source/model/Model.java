package model;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import java.awt.Toolkit;
import model.sprites.dynamic.Player;
import view.View;



/*
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Model {

	final private int startingXOffSet = 192;
	//get the screen's dimensions
	final private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double screenRatio;
	
	private int xBoundary;
	private int yBoundary;
	
	private Platform ground;
	private Platform platform1;
	int groundOffSet = 100;
	private Player player;
	
	//fixed gravity constant
	private int gravity = 10;
	
	private boolean changeCharacterMode = false;
	private int changeCharacterCount = 0;
	private int startingY;
	private int startingX;
	
	
	
	
	
	/**
	 * 	Constructor
	 */
	public Model(){
		
		//get the screen's ratio
		screenRatio = screenWidth/screenHeight;
		int playerWidth = (int) (screenWidth * 0.1);
		int playerHeight = (int) (playerWidth * screenRatio);
		
		startingY = (int) (screenHeight - groundOffSet - playerHeight);
		startingX = playerWidth - startingXOffSet;
		//set the boundaries
		xBoundary = (int)screenWidth - playerWidth;
		yBoundary = (int)screenHeight - playerHeight;
		
		//create Player object
		player = new Player(startingX,startingY,((int) (playerWidth*.75)),playerHeight, gravity);
		//create Ground object
		ground = new Platform(-500, (int)(screenHeight - groundOffSet),(int)(screenWidth*2),groundOffSet);
		platform1 = new Platform((int) ThreadLocalRandom.current().nextInt(300, 1000), (int) ThreadLocalRandom.current().nextInt(765, 900), 350, 50);
	}
	
	//************************
	//Methods
	//getters for the boundaries
	
	
	/**
	 * Returns an int value of the screen X-Boundary
	 *
	 * @return      X-Boundary specific to your screen size
	 * @see         int
	 */
	public int getXBoundary(){
		return xBoundary;
	}
	
	/**
	 * Returns an int value of the screen Y-Boundary
	 *
	 * @return      Y-Boundary specific to your screen size
	 * @see         int
	 */
	public int getYBoundary(){
		return yBoundary;
	}
	
	//getter for player dimensions
	/**
	 * Returns an double value of the player image width
	 *
	 * @return      width of the player image
	 * @see         double
	 */
	public double getPlayerWidth(){
		return player.getWidth();
	}
	
	/**
	 * Returns an double value of the player image height
	 *
	 * @return      height of the player image
	 * @see         double
	 */
	public double getPlayerHeight(){
		return player.getHeight();
	}
	
	/**
	 * Returns an int value of the player X-Location
	 *
	 * @return      Player X-Coordinate
	 * @see         int
	 */
	public int getPlayerX(){
		return (int) player.getX();
	}
	
	/**
	 * Returns an int value of the player Y-Location
	 *
	 * @return      Player Y-Coordinate
	 * @see         int
	 */
	public int getPlayerY(){
		return (int) player.getY();
	}
	
	//getter for ground
	/**
	 * Returns a rectangle object that is supposed to be ground for the game
	 *
	 * @return      Rectangle ground object
	 * @see         Rectangle
	 */
	public Rectangle getGround(){
		return ground;
	}
	
	/**
	 * Returns a rectangle object that is supposed to be platform for the game
	 *
	 * @return      Rectangle platform object
	 * @see         Rectangle
	 */
	public Rectangle getPlatform() {
		return platform1;
	}
	
	/**
	 * Returns a rectangle object that is supposed to be platform for the game
	 *
	 * @return      Rectangle platform object
	 * @see         Rectangle
	 */
	public Platform getPlat() {
		return platform1;
	}
	
	//move the player
	/**
	 * Updates player x and y coordinates 
	 *
	 * @see         Rectangle
	 */
	public void movePlayer(){
		player.move();
	}
	
	public void setChangePlayerMode(){
		changeCharacterMode = !changeCharacterMode;
	}
	public boolean getChangeCharacterMode() {
		return changeCharacterMode;
	}
	public void incrementChangeCharacterCount() {
		changeCharacterCount++;
	}
	public void decrementChangeCharacterCount() {
		changeCharacterCount--;
	}
	public int getChangeCharacterCount() {
		return changeCharacterCount;
	}
	public String getPlayerCharacter() {
		return player.getPlayerCharacter(changeCharacterCount);
			
	}
	
	//setter for player's dx
	public void playerMoveLeft(){
		player.setDirection(0);
		//check if player is going out of x bound
		if(player.getX() >= 0)
		{
			//System.out.println("Boundary invalid " + xBoundary);
			player.moveLeft();
			//System.out.println("ground" + ground.getWidth());
		}
		//if out of bound then don't increment the x
		else
		{
			System.out.println("Boundary invalid 0");
			System.out.println("Player is out of Boundary to Left");
			player.setDxOff();
		}
	}
	public void playerMoveRight(){
		player.setDirection(1);
		//check if player is going out of x bound
		if(player.getX() <= xBoundary)
		{
			//System.out.println("Boundary invalid " + xBoundary);
			player.moveRight();
			//System.out.println("ground" + ground.getWidth());
		}
		else
		{
			System.out.println("Boundary invalid " + xBoundary);
			System.out.println("Player is out of Boundary to Right");
			player.setDxOff();
		}
	}
	public void setPlayerDxOff(){
		player.setDxOff();
	}
	
	//getter for player's direction
	public int getPlayerDirection(){
		return player.getDirection();
	}
	public String getPlayerDirectionString(){
		return player.getDirectionString();
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
		boolean stillFalling;
			stillFalling = player.gravityEffect(ground);
			if(stillFalling)
			{
				player.gravityEffect(platform1);
			}
		
	}
	
	public void checkCollision() {
		player.playerPlatCollision(platform1);
	}
	
	
	public void createNewPlatform() {
		platform1 = new Platform((int) ThreadLocalRandom.current().nextInt(300, 1000), (int) ThreadLocalRandom.current().nextInt(765,900), 350, 50);
	}
	
	public void changeRoom() {
		if (player.getX() > xBoundary || player.getY() > yBoundary) {
			player.setLocation(startingX, startingY);
			
			createNewPlatform();
		}
	}
	
	public static void main(String[] args) {
        System.out.println("Hello World");
        Model model = new Model();
       
       
        for(int i = 0; i< 10; i++) {
            System.out.println();
            model.incrementChangeCharacterCount();
            model.playerMoveRight();
            System.out.println("Current character is a " + model.getPlayerCharacter() +
                    " and is moving "+ model.getPlayerDirectionString());
           
            for(int j = 0; j < 6 ;j++) {
                System.out.println("Player Coords: (" +model.getPlayerX() +", "+ model.getPlayerY()+")");
                model.movePlayer();
                System.out.println("movePlayer() executed");
            }
           
            System.out.println();
           
            model.playerMoveLeft();
            System.out.println("Changing Character and Direction");
            model.incrementChangeCharacterCount();
            System.out.println("Current character is a " + model.getPlayerCharacter() +
                    " and is facing "+ model.getPlayerDirectionString());
           
            System.out.println();
           
            for(int k = 0; k < 6 ;k++) {
                System.out.println("Player Coords: (" +model.getPlayerX() +", "+ model.getPlayerY()+")");
                model.movePlayer();
                System.out.println("movePlayer() executed");
            }
           
           
        }
    }
	
}
