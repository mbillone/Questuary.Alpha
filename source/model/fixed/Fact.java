package model.fixed;

import model.StaticObject;

public class Fact extends StaticObject {
	
	// *************************************************
		// Fields
		
		// x and y locations
		private static int xLoc;
		private static int yLoc;

		// *************************************************
		// Constructor

		// for regular display
		/**
		 * Constructor for the Fact object
		 */
		public Fact() {
			super.setName("fact");

			// set the dimensions
			super.setSize(100, 60);
			
			xLoc = (int) (super.getScreenWidth()/2 - this.width/2);
			yLoc = 40;

			super.setLocation(xLoc, yLoc);
		}

		/**
		 * Gets the x location of the fact on screen
		 * @return xLoc - x location of the fact
		 */
		public static int getxLoc() {
			return xLoc;
		}

		/**
		 * Gets the y location of the fact on screen
		 * @return yLoc - y location of the fact
		 */
		public static int getyLoc() {
			return yLoc;
		}
		
}
