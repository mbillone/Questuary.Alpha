package model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import model.sprites.dynamic.Enemy;
import model.sprites.dynamic.Player;
import model.sprites.fixed.Obstacle;
import view.View;

public class Model {
	
	private Player player = new Player(100,500);
	private View view;
	private int xBoundary;
	private int yBoundary;
	
	private int groundX;
	private int groundY;
	private Rectangle ground;
	
	public Model() {
		xBoundary = 1000;
		yBoundary = 1000;
		
		groundX = 0;
		groundY = 500;
		ground = new Rectangle(groundX,groundY,xBoundary, 1);

	}
	
	public int getXBoundary() {
		return xBoundary;
	}
	
	public int getYBoundary() {
		return yBoundary;
		
	}
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	//get ground Rectangle;
	public Rectangle getGround(){
		return ground;
	}	
	
	public int getPlayerDirection() {
		return player.getDirection();
	}

	//move the player
	public void incrementX(){
		player.incrementX();
	}
	public void decrementX(){
		player.decrementX();
	}
	public void setDirection(int i){
		player.setDirection(i);
	}
	public int getDirection(){
		return player.getDirection();
	}
	public String getDirectState(){
		return player.getDirectionState();
	}
}