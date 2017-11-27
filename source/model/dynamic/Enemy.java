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
	public void damage(Player p) {
		if (!hasAttacked) {
			p.setHealth(p.getHealth() - damage);
			System.out.println("Player Health: " + p.getHealth());
		}
	}

	// *************************************************
	// Getters

	public int getBound1() {
		return bound1;
	}

	public int getBound2() {
		return bound2;
	}

	public boolean getHasAttacked() {
		return hasAttacked;
	}

	public boolean isKillable() {
		return killable;
	}

	public boolean isDead() {
		return dead;
	}

	// *************************************************
	// Setters

	// set damage
	public void setDamage(int d) {
		damage = d;
	}

	public void setBoundary(int x1, int x2) {
		bound1 = x1;
		bound2 = x2;
	}

	public void setHasAttacked(boolean b) {
		hasAttacked = b;
	}

	public void setKillable(boolean b) {
		killable = b;
	}

	public void setIsDead() {
		dead = true;
	}

}
