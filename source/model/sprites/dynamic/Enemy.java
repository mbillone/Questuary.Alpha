package model.sprites.dynamic;

import model.DynamicSprites;

public abstract class Enemy extends DynamicSprites{
	
	boolean killable; 
	int health;
	
	void damage(Player p) {
		
	}
	
	void changeHealth(boolean killable, int health) {
		
	}
	
	void move() {
		
	}	
	
}
