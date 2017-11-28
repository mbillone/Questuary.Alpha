package model.fixed;

import model.StaticObject;

public class Fact extends StaticObject {
	
	// *************************************************
		// Fields
		
		// x and y locations
		private static int xLoc;
		private static int yLoc;
		
		// scroll to next fact
		private static int picIter = 0;

		// *************************************************
		// Constructor

		public Fact() {
			super.setName("fact");
			
			if (picIter < 15) {
				picIter++;
			} else {
				picIter = 0;
			}

			// set the dimensions
			super.setSize(100, 60);
			
			xLoc = (int) (super.getScreenWidth()/2 - this.width/2);
			yLoc = 40;

			super.setLocation(xLoc, yLoc);
		}

		public static int getxLoc() {
			return xLoc;
		}

		public static int getyLoc() {
			return yLoc;
		}
		
		public static int getPicIter() {
			return picIter;
		}
		
}
