package model.dynamic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import controller.Controller;
import model.DynamicObject;
import model.fixed.Platform;
import view.View;

public class Player extends DynamicObject {

	// *************************************************
	// Fields

	// the state of the player
	private String state = "Cat";

	// assuming only player can jump and fall
	private int maxYVelocity = 15;
	private int minYVelocity = -15;

	private int maxJumpHeight;
	// use prevY later to compare with maxJumpingHeight
	private double prevY;
	private int gravity;

	// set player to default falling and cannot jump
	private boolean falling = true;
	private boolean jumping = false;

	// use for changing player's character
	private int changeCharacterCount = 0;
	private int numOfCharacter = 2;

	// *************************************************
	// Constructor

	public Player(int xCoord, int yCoord, int width, int height, int gravity) {
		// setLocation in Rectangle class used to set x and y coordinate
		super.setLocation(xCoord, yCoord);

		// set player size
		super.setSize(width, height);

		// set max jumping height
		maxJumpHeight = height;

		// set gravity location
		this.gravity = gravity;

		// set player facing right
		super.setDirection(1);

		// initialize player's dx and dy to 0
		super.setXVelocity(0);
		super.setYVelocity(0);
	}

	// *************************************************
	// Methods

	// determines if touching the ground with appropriate actions for jumping and
	// falling
	public boolean gravityEffect(Rectangle ground) {
		Rectangle rect = new Rectangle((int) ground.getX(), (int) ground.getY(), (int) (ground.getWidth() * .75),
				(int) ground.getHeight());

		// determine if the player is falling
		falling = !(super.y <= ground.getY());

		// if player is not touching the ground and is not jumping then the player is
		// falling
		if (falling && !jumping) {
			playerFalling();
			return true;

		} else if (falling && jumping) {
			// if player is not touching the ground but is jumping then allow player to jump
			if ((prevY - super.y) < maxJumpHeight) {
				// has the player reached max jumping height yet
				System.out.println("Start First Stage Gravity Effect");
				playerJumping();
			} else {
				System.out.println("Finish First Stage Gravity Effect");
				// if max height reached then player stops jumping/ascending
				jumping = false;
			}
			return true;

		} else if (!falling && jumping) {
			// if player is touching the ground but is not jumping then allow player to jump
			if ((prevY - super.y) < maxJumpHeight) {
				System.out.println("Start Second Stage Gravity Effect");
				playerJumping();
			} else {
				System.out.println("Finish Second Stage Gravity Effect");
				jumping = false;
			}
			return false;

		} else {
			// if player is on a surface then set dy to 0
			super.setYVelocity(0);
			return false;
		}
	}

	// make the player fall
	public void playerFalling() {
		System.out.println("In playerFalling");
		if (super.getYVelocity() <= maxYVelocity) {
			int newYVeloc = super.getYVelocity() + gravity;
			super.setYVelocity(newYVeloc);
		}
		System.out.println("Finish playerFalling");
	}

	// make the player jump
	public void playerJumping() {
		System.out.println("In playerJumping");
		if (super.getYVelocity() >= minYVelocity) {
			int newYVeloc = super.getYVelocity() - gravity;
			super.setYVelocity(newYVeloc);
		}
		System.out.println("Finish playerJumping");
	}

	public void playerPlaformCollision(Platform plat) {
		if (this.intersects(plat.getLeft()) && this.getDirection() == 1) {
			this.setXVelocity(0);
		} else if (this.intersects(plat.getRight()) && this.getDirection() == 0) {
			this.setXVelocity(0);
		}
		
		/*Area areaPlayer = new Area(this.getBounds());
		Rectangle2D areaPlat = plat.getBounds2D();
		
		if (areaPlayer.intersects(areaPlat) && this.getDirection() == 1) {
			this.turnDeltaXOff();
		} else if (areaPlayer.intersects(areaPlat) && this.getDirection() == 0) {
			this.turnDeltaXOff();
		}*/
	}

	// *************************************************
	// Getters

	// getter for jumping
	public boolean isJumping() {
		return jumping;
	}

	// getter for falling
	public boolean isFalling() {
		return falling;
	}

	public String getPlayerCharacter() {
		if (changeCharacterCount % numOfCharacter == 0) {
			return "cat";
		} else {
			return "dog";
		}
	}

	public int getXCoord() {
		return (int) super.getX();
	}

	public int getYCoord() {
		return (int) super.getY();
	}
	
	public int getMaxJumpHeight() {
		return maxJumpHeight;
	}
	// *************************************************
	// Setters

	// setter for the player's dimensions
	public void setDimensions(int width, int height) {
		super.setSize(width, height);
	}

	// setter for turning the dx to left, right, or 0
	public void moveLeft() {
		super.setXVelocity(-20);
	}

	public void moveRight() {
		super.setXVelocity(20);
	}

	public void turnDeltaXOff() {
		super.setXVelocity(0);
	}

	// setter for jumping
	public void setJumping() {
		jumping = true;
		prevY = super.getY();
	}

	// setter for maxJumpingHeight
	public void setMaxJumpingHeight(int num) {
		maxJumpHeight = num;
	}

}
