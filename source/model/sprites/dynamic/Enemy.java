package model.sprites.dynamic;

import model.Sprites;

public abstract class Enemy extends Sprites{

	boolean killable; 
	int health;
	
	void damage(Player p) {
		
	}
	
	void changeHealth(boolean killable, int health) {
		
	}
	
	void move() {
		
	}	
	
}
