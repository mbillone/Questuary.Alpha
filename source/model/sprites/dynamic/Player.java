package model.sprites.dynamic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.Sprites;
import model.sprites.fixed.Collectible;

public class Player extends Sprites {
	
	private int health; 
	private int score; 
	private List<Collectible> collectibles;
	private boolean invincibility; 
	
	//vars for decrementing and incrementing movement
	private int deltaX = 10;
	private int deltaY = 10;
	
	//0 = player facing left, 1 = player facing right
	private int direction = 1;
	private int numOfCharacter = 2;
	private int changeCharacterCount = 0;
	
	//Assuming only player can jump and fall
	private int maxDeltaY = 15;
	private int minDeltaY = -15;
			
	private int maxJumpingHeight;
	//use prevY later to compare with maxJumpingHeight
	private double prevY;
	private int gravity;
	
	//set player to default falling and cannot jump
	private boolean falling = true;
	private boolean jumping = false;
	
	public Player(int xCoord, int yCoord, int width, int height, int gravity) {
		//set location
		super.setX(xCoord);
		super.setY(yCoord);
		
		//set player size
		super.setSize(width, height);
		
		maxJumpingHeight = height;
		
		//set gravity value
		this.gravity = gravity;
		
		this.health = 3;
		this.score = 0;
		this.collectibles = new ArrayList<Collectible>(3);
		this.invincibility = false;
	}
	
	//determines if touching the ground with appropriate actions for jumping and falling
	public void gravityEffect(Rectangle ground) {
		//determine if the player is falling
		falling = !(this.intersects(ground));
		
		//if player is not touching the ground and is not jumping then the player is falling
		if(falling && !jumping) {
			playerFalling();
		} else if (falling && jumping) {
			//if player is not touching the ground but is jumping then allow player to jump
			//has the player reached max jumping height yet
			if((prevY - yCoord) < maxJumpingHeight) {
				System.out.println("in first case gravity effect");
				playerJumping();
			} else {
				System.out.println("finish first case gravity effect");
				//if max height reached then player stops jumping/ascending
				jumping = false;
			}
		} else if (!falling && jumping) {
			//if player is touching the ground but is not jumping then allow player to jump
			if((prevY - yCoord) < maxJumpingHeight) {
				System.out.println("in second case gravity effect");
				playerJumping();
			} else {
				System.out.println("finish second case gravity effect");
				jumping = false;
			}
		} else {
			//if player is on a surface then set dy to 0
			setDeltaY(0);
		}
	}
	
	//make the player fall
	public void playerFalling() {
		if(getDeltaY() <= maxDeltaY)
		{
			int newDeltaY = getDeltaY() + gravity;
			setDeltaY(newDeltaY);
		}
	}
	
	//make the player jump
	public void playerJumping() {
		System.out.println("in playerJumping");
		if(getDeltaY() >= minDeltaY) {
			int newDeltaY = getDeltaY() - gravity;
			setDeltaY(newDeltaY);
		}
		System.out.println("finish playerJumping");
	}
	
	public void move() {
		xCoord += deltaX;
		yCoord += deltaY;		
	}
	
	public int getDeltaY() {
		return deltaY;
	}
	
	public int getDeltaX() {
		return deltaX;
	}
	
	public void setDeltaXOff() {
		deltaX = 0;
	}
	
	//setter for turning the dx between left, right, and 0
	public void moveLeft(){
		deltaX = -20;
	}
	
	public void moveRight(){
		deltaX = 20;
	}
	
	//getter for jumping
	public boolean getJumping(){
		return jumping;
	}
	//getter for falling
	public boolean getFalling(){
		return falling;
	}	
	
	public int getDirection() {
		return direction;
	}
	
	public String getDirectionState() {
		if(getDirection() == 1) {
			return ": Facing RIGHT";
		} else {
			return ": Facing LEFT";
		}
	}
	
	public String getPlayerCharacter(int changeCharacterCount) {
		if((changeCharacterCount % numOfCharacter) == 0) {
			return "cat";
		} else {
			return "dog";
		}
	}
	
	public List<Collectible> getCollectibles() {
		return collectibles;
	}
	
	public void addToCollectibles(Collectible item) {
		collectibles.add(item);
	}
	
	public int getScore() {
		return score;
	}
	
	public void incrementSpeed() {
		deltaX++;
		deltaY++;
	}
	
	public void incrementScore() {
		score++;
	}
	
	public void setDeltaY(int num) {
		deltaY = num;
	}
	
	//setter for jumping
	public void setJumping(){
		jumping = true;
		prevY = super.getY();
	}
	
	//setter for maxJumpingHeight
	public void setMaxJumpingHeight(int maxH){
		maxJumpingHeight = maxH;
	}
	
	public void setPlayerSize(int width, int height) {
		super.setSize(width, height);
	}
	
	
	public void setInvincibility(boolean bool) {
		this.invincibility = bool;
	}
	
	public void setDirection(int num) {
		direction = num;		
	}
}
