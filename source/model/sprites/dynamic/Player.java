package model.sprites.dynamic;

import java.util.ArrayList;
import java.util.List;

import model.DynamicSprites;
import model.sprites.fixed.Collectible;

public class Player extends DynamicSprites {
	
	int health; 
	int score; 
	List<Collectible> collectibles;
	boolean invincibility; 
	
	public Player() {
		this.health = 3;
		this.score = 0;
		this.collectibles = new ArrayList<Collectible>(3);
		this.invincibility = false;
	}
	
	void move() {
		
	}
	
	void changeCharacter() {
		
	}
	
	void changeHealth(int num) {
		
	}
	
	void changeSpeed(int num) {
		
	}
	
	void addToCollectibles(Collectible item) {
		collectibles.add(item);
	}
	
	List<Collectible> getCollectibles() {
		return collectibles;
	}
	
	void setInvincibility(boolean bool) {
		this.invincibility = bool;
	}
	
	int getScore() {
		return score;
	}
	
	void incrementScore(int i) {
		score = score + i;
	}
		
}
