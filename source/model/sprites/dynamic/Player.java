package model.sprites.dynamic;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import model.DynamicObject;

public class Player extends DynamicObject{
	
	//The state of the player
	private String state = "Cat";

	//Assuming only player can jump and fall
	private int maxDy = 15;
	private int minDy = -15;
			
	private int maxJumpingHeight;
	//use prevY later to compare with maxJumpingHeight
	private double prevY;
	private int gravity;
	
	//set player to default falling and cannot jump
	private boolean falling = true;
	private boolean jumping = false;
	
	//drawing hitLines
	Line2D = new Line2D();
	
	private int changeCharacterCount = 0;
	private int numOfCharacter = 2;
	
	
	
	//*************************************************
	//Constructor
	public Player(int x, int y, int width, int height,int gravity){
		//setLocation in Rectangle class used to set x and y coordinate
		super.setLocation(x,y);
		
		//set player size
		super.setSize(width, height);
		
		//set max jumping height
		maxJumpingHeight = height/2;
		
		//set gravity location
		this.gravity = gravity;
		
		//set player facing right
		super.setDirection(1);
		
		//initialize player's dx and dy to 0
		super.setDx(0);
		super.setDy(0);
	}
	
	//*******************************************
	//Methods
	
	//getter for jumping
	public boolean getJumping(){
		return jumping;
	}
	//getter for falling
	public boolean getFalling(){
		return falling;
	}
	
	//setter for the player's dimensions
	public void setDimensions(int width,int height)
	{
		super.setSize(width, height);
	}
	
	//setter for turning the dx between left, right, and 0
	public void moveLeft(){
		super.setDx(-20);
	}
	public void moveRight(){
		super.setDx(20);
	}
	public void setDxOff(){
		super.setDx(0);
	}
	
	//setter for jumping
	public void setJumping(){
		jumping = true;
		prevY = super.getY();
	}
	
	//setter for maxJumpingHeight
	public void setMaxJumpingHeight(int j){
		maxJumpingHeight = j;
	}
	
	public int getMaxJumpingHeight() {
		return maxJumpingHeight;
	}
	
	//determines if touching the ground with appropriate actions for jumping and falling
	public boolean gravityEffect(Rectangle ground){
		Rectangle r = new Rectangle( (int)ground.getX(), (int) ground.getY(),(int) (ground.getWidth()*.75), (int) ground.getHeight());
		//determine if the player is falling
		falling = !(this.intersects(r));
		
		//if player is not touching the ground and is not jumping then the player is falling
		if(falling && !jumping)
		{
			playerFalling();
			return true;
		}
		//if player is not touching the ground but is jumping then allow player to jump
		else if (falling && jumping)
		{
			//has the player reached max jumping height yet
			if((prevY - y) < maxJumpingHeight)
			{
				System.out.println("in first case gravity effect");
				playerJumping();
			}
			else
			{
				System.out.println("finish first case gravity effect");
				//if max height reached then player stops jumping/ascending
				jumping = false;
			}
			return true;
		}
		//if player is touching the ground but is not jumping then allow player to jump
		else if (!falling && jumping)
		{
			if((prevY - y) < maxJumpingHeight)
			{
				System.out.println("in second case gravity effect");
				playerJumping();
			}
			else
			{
				System.out.println("finish second case gravity effect");
				jumping = false;
			}
			return false;
		}
		//if player is on a surface then set dy to 0
		else
		{
			super.setDy(0);
			return false;
		}
	}
	
	//make the player fall
	public void playerFalling(){
		if(super.getDY() <= maxDy)
		{
			int newDy = super.getDY() + gravity;
			super.setDy(newDy);
		}
	}
	
	//make the player jump
	public void playerJumping(){

		System.out.println("in playerJumping");
		if(super.getDY() >= minDy)
		{
			int newDy = super.getDY() - gravity;
			super.setDy(newDy);
		}

		System.out.println("finish playerJumping");
	}

	public String getPlayerCharacter(int changeCharacterCount) {
		// TODO Auto-generated method stub
		if(changeCharacterCount % numOfCharacter == 0) {
			return "cat";
		}else {
			return "dog";
		}
	}
}
