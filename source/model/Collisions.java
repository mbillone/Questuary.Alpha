package model;

import model.sprites.dynamic.Enemy;
import model.sprites.dynamic.Player;
import model.sprites.fixed.Obstacle;

public class Collisions {
	
	boolean playerCollidesBorder(Player player) {
		return false;
	}

	int playerCollidesObstacle(Player player, Obstacle obj) {
		return -1;
	}

	int playerCollidesEnemy(Player player, Enemy enemy, boolean bool) {
		return -1;
	}

	void enemyCollidesEnemy(Enemy enemy1, Enemy enemy2) {

	}

	void enemyCollidesObstacle(Enemy enemy, Obstacle obj) {

	}

}
