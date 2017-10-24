package model;

import model.sprites.dynamic.Enemy;
import model.sprites.dynamic.Player;
import model.sprites.fixed.Obstacle;

public class Model {
	
	void main(String args[]) {
		
	}
	
	boolean playerCollidesBorder(Player p) {
		return false;
	}
	
	int playerCollidesObstacle(Player p, Obstacle o) {
		return -1;
	}
	
	int playerCollidesEnemy(Player p, Enemy e, boolean b) {
		return -1;
	}
	
	void enemyCollidesEnemy(Enemy e1, Enemy e2) {
		
	}
	
	void enemyCollidesObstacle(Enemy e, Obstacle o) {
		
	}
	
}

abstract class Sprites extends Model {
	
	int xCoord; 
	int yCoord; 
	
	int getX() {
		return xCoord;
	}
	
	int getY() {
		return yCoord;
	}

}