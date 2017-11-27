package model.fixed;

import java.util.HashMap;
import java.util.List;
import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Chest extends StaticObject {

	// *************************************************
	// Fields

	// field for when to open the chest
	private boolean isOpen = false;

	// *************************************************
	// Constructor

	public Chest(Platform platform) {

		super.setName("chest");

		// set the dimensions
		double width = 0.05 * super.getScreenWidth();
		double height = width * super.getScreenRatio();
		super.setSize((int) width, (int) height);

		super.setLocation((int) (platform.getX() + platform.getWidth() / 2 - this.getWidth() / 2),
				(int) (platform.getY() - this.getHeight()));
	}

	// *************************************************
	// Getters

	public boolean getIsOpen() {
		return isOpen;
	}

	// *************************************************
	// Setters

	public void setIsOpen(boolean b) {
		isOpen = b;
	}

}
