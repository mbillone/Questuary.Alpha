package model.fixed;

import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Ground extends StaticObject {

	// *************************************************
	// Constructor

	public Ground(int x, int y, int width, int height) {
		super.setName("ground");
		
		super.setBounds(x, y, width, height);
	}
}
