package model;

import java.awt.Rectangle;

import model.sprites.dynamic.Enemy;
import model.sprites.dynamic.Player;
import model.sprites.fixed.Obstacle;

public class Sprites extends Rectangle {

	protected static int xCoord; 
	protected static int yCoord; 	
	
	protected int width;
	protected int height;
	
	public double getX() {
		return xCoord;
	}
	
	public double getY() {
		return yCoord;
	}
	
	public void setX(int newX) {
		xCoord = newX;
	}
	
	public void setY(int newY) {
		yCoord = newY;
	}
	
	public void setSize(int newWidth, int	newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
}
