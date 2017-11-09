package model.fixed;

import java.awt.Rectangle;

import model.StaticObject;

public class Platform extends StaticObject {

	public Platform(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public Rectangle getRight() {
		return super.getRight();
	}
	
	public Rectangle getLeft() {
		return super.getLeft();
	}
	
	
}
