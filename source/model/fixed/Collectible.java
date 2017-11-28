package model.fixed;

import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Collectible extends StaticObject {

	// *************************************************
	// Fields
	
	// values for the collected collectibles display location
	private static int heightIter;
	private static int xLoc;
	private static int yLoc;

	// *************************************************
	// Constructor

	// for regular display
	public Collectible(Platform platform) {
		super.setName("collectible");

		// set the dimensions
		double width = 0.05 * super.getScreenWidth();
		double height = width * super.getScreenRatio();
		super.setSize((int) width, (int) height);

		super.setLocation((int) (platform.getX() + platform.getWidth() / 2 - this.getWidth() / 2),
				(int) (platform.getY() - this.getHeight()));
	}

	// for collected display
	public Collectible(int numCollected) {
		super.setName("collectible");

		// set the dimensions
		double width = 0.05 * super.getScreenWidth();
		double height = width * super.getScreenRatio();
		super.setSize((int) width, (int) height);

		// x and y coordinates for the collected
		if (numCollected < 3) {
			xLoc = (int) (width * numCollected);
			yLoc = 0;
		} else if (numCollected % 3 == 0) {
			heightIter++;
			xLoc = 0;
			yLoc = (int) (height * heightIter);
		} else {
			xLoc = (int) (width * (numCollected % 3));
			yLoc = (int) (height * heightIter);
		}
		super.setLocation(xLoc, yLoc);

	}

	// *************************************************
	// Setters

	public static void setHeightIter(int i) {
		heightIter = i;
	}

}
