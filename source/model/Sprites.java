package model;

import model.sprites.dynamic.Enemy;
import model.sprites.dynamic.Player;
import model.sprites.fixed.Obstacle;

public class Sprites {

	protected int xCoord; 
	protected int yCoord; 	
	
	public int getX() {
		return xCoord;
	}
	
	public int getY() {
		return yCoord;
	}
	
	public void setX(int newX) {
		xCoord = newX;
	}
	
	public void setY(int newY) {
		yCoord = newY;
	}
	
}
