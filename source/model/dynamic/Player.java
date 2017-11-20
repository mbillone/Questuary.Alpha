package model.dynamic;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import model.DynamicObject;
import model.fixed.Platform;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Player extends DynamicObject {

	// *************************************************
	// Fields

	// The state of the player
	private String state = "Cat";

	// Assuming only player can jump and fall
	private int maxDy = 15;
	private int minDy = -15;

	private int maxJumpingHeight;
	// use prevY later to compare with maxJumpingHeight
	private double prevY;
	private int gravity;

	// set player to default falling and cannot jump
	private boolean falling = true;
	private boolean jumping = false;

	private int changeCharacterCount = 0;
	private int numOfCharacter = 2;
	
	private int score = 0;

	// *************************************************
	// Constructor

	public Player(int x, int y, int width, int height, int gravity) {
		// setLocation in Rectangle class used to set x and y coordinate
		super.setLocation(x, y);

		// set player size
		super.setSize(width, height);

		// set max jumping height
		maxJumpingHeight = height / 2;

		// set gravity location
		this.gravity = gravity;

		// set player facing right
		super.setDirection(1);

		// initialize player's dx and dy to 0
		super.setDx(0);
		super.setDy(0);
	}

	// *************************************************
	// Methods

	// determines if touching the ground with appropriate actions for jumping and
	// falling
	public boolean gravityEffect(Rectangle ground) {
		Rectangle r = new Rectangle((int) ground.getX(), (int) ground.getY(), (int) (ground.getWidth() * .75),
				(int) ground.getHeight());
		// determine if the player is falling
		falling = !(this.intersects(r));

		// if player is not touching the ground and is not jumping then the player is
		// falling
		if (falling && !jumping) {
			playerFalling();
			return true;
		}
		// if player is not touching the ground but is jumping then allow player to jump
		else if (falling && jumping) {
			System.out.println("Executed: First Stage gravityEffect()");
			// has the player reached max jumping height yet
			if ((prevY - y) < maxJumpingHeight) {

				playerJumping();
			} else {
				// if max height reached then player stops jumping/ascending
				jumping = false;
			}
			return true;
		}
		// if player is touching the ground but is not jumping then allow player to jump
		else if (!falling && jumping) {
			System.out.println("Executed: Second Stage gravityEffect()");
			if ((prevY - y) < maxJumpingHeight) {
				playerJumping();
			} else {
				jumping = false;
			}
			return false;
		}
		// if player is on a surface then set dy to 0
		else {
			super.setDy(0);
			return false;
		}
	}

	// make the player fall
	public void playerFalling() {
		if (super.getDy() <= maxDy) {
			int newDy = super.getDy() + gravity;
			super.setDy(newDy);
		}
	}

	// make the player jump
	public void playerJumping() {

		System.out.println("Executed: playerJumping()");
		if (super.getDy() >= minDy) {
			int newDy = super.getDy() - gravity;
			super.setDy(newDy);
		}
	}

	// collision between player and platforms
	public void playerPlatCollision(Platform plat) {
		if (this.intersects(plat.getLeft()) && this.getDirection() == 1) {
			this.setDx(0);
		} else if (this.intersects(plat.getRight()) && this.getDirection() == 0) {
			this.setDx(0);
		}
		/*
		 * else if(!this.intersects(plat.getLeft()) && this.getDirection() == 1) {
		 * this.setDx(20); } else if (!this.intersects(plat.getRight()) &&
		 * this.getDirection() == 0) { this.setDx(-20); }
		 */
	}
	
	public void incrementScore() {
		score += score;
	}

	// *************************************************
	// Getters

	// getter for jumping
	public boolean getJumping() {
		return jumping;
	}

	// getter for falling
	public boolean getFalling() {
		return falling;
	}

	public int getMaxJumpingHeight() {
		return maxJumpingHeight;
	}

	public String getPlayerCharacter(int changeCharacterCount) {
		// TODO Auto-generated method stub
		if (changeCharacterCount % numOfCharacter == 0) {
			maxJumpingHeight = height / 2;
			state = "cat";
			return "cat";
		} else {
			maxJumpingHeight = height;
			state = "bird";
			return "bird";
		}
	}

	// *************************************************
	// Setters

	// setter for the player's dimensions
	public void setDimensions(int width, int height) {
		super.setSize(width, height);
	}

	// setter for turning the dx between left, right, and 0
	public void moveLeft() {
		super.setDx(-20);
	}

	public void moveRight() {
		super.setDx(20);
	}

	public void setDxOff() {
		super.setDx(0);
	}

	// setter for jumping
	public void setJumping() {
		jumping = true;
		prevY = super.getY();
	}

	// setter for maxJumpingHeight
	public void setMaxJumpingHeight(int j) {
		maxJumpingHeight = j;
	}

}
