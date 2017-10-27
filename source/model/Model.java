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
	
	private View view;
	private int xBoundary;
	private int yBoundary;
	private int startingX = 0;
	private int startingY = 500;
	private Player player = new Player(startingX,startingY);
	
	private int groundX;
	private int groundY;
	private Rectangle ground;
	private boolean changeCharacterMode;
	private int changeCharacterCount = 0;
	
	public Model() {
		xBoundary = 1000;
		yBoundary = 1000;
		
		groundX = 0;
		groundY = 500;
		ground = new Rectangle(groundX,groundY,xBoundary, 1);
		changeCharacterMode = false;

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
	
	
	//change room player is in
	public void changeRoom(){
		if (getPlayerX() >= (xBoundary - (view.getImgwidth()/2))) {
			player.setX(startingX);
		}
		
	}
}