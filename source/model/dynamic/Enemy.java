package model.dynamic;

import java.awt.Toolkit;

import model.DynamicObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public abstract class Enemy extends DynamicObject {

	// *************************************************
	// Fields

	boolean killable = false;
	private boolean dead = false;
	boolean hasAttacked = false;
	int health;
	int damage;
	int bound1;
	int bound2;

	// *************************************************
	// Methods

	// only damage player once
	/**
	 * Deals damage to the player when hit
	 * 
	 * @param p
	 *            - Player object to be damaged
	 * 
	 */
	public void damage(Player p) {
		if (!hasAttacked) {
			p.setHealth(p.getHealth() - damage);
			System.out.println("Player Health: " + p.getHealth());
		}
	}

	// *************************************************
	// Getters

	/**
	 * Gets the first boundary of the enemy
	 * 
	 * @return bound1 - integer for the first boundary
	 */
	public int getBound1() {
		return bound1;
	}

	/**
	 * Gets the second boundary for the enemy
	 * 
	 * @return bound2 - integer for the second boundary
	 */
	public int getBound2() {
		return bound2;
	}

	/**
	 * Gets the boolean to determine if the enemy was attacked or not
	 * 
	 * @return hasAttacked - boolean to determine whether or not the enemy was
	 *         attacked
	 */
	public boolean getHasAttacked() {
		return hasAttacked;
	}

	/**
	 * Determines whether or not an enemy is killable
	 * 
	 * @return killable - boolean determining whether or not the enemy can be killed
	 */
	public boolean isKillable() {
		return killable;
	}

	/**
	 * Checks to see if the enemy is dead
	 * 
	 * @return dead - boolean to determine whether or not the enemy is alive or dead
	 */
	public boolean isDead() {
		return dead;
	}

	// *************************************************
	// Setters

	// set damage
	/**
	 * Sets the amount of damage to give
	 * 
	 * @param d
	 *            - Amount of damage to do
	 */
	public void setDamage(int d) {
		damage = d;
	}

	/**
	 * Sets the boundaries for the enemies to move
	 * 
	 * @param x1
	 *            - Left boundary
	 * @param x2
	 *            - Right boundary
	 */
	public void setBoundary(int x1, int x2) {
		bound1 = x1;
		bound2 = x2;
	}

	/**
	 * Sets the attack boolean
	 * 
	 * @param b
	 *            - Boolean for whether or not the enemy has attacked
	 */
	public void setHasAttacked(boolean b) {
		hasAttacked = b;
	}

	/**
	 * Sets the killable boolean
	 * 
	 * @param b
	 *            - Boolean for whether or not the enemy is killable
	 */
	public void setKillable(boolean b) {
		killable = b;
	}

	/**
	 * Sets the dead boolean
	 */
	public void setIsDead() {
		dead = true;
	}

}
