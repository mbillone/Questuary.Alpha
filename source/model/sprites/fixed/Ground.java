package model.sprites.fixed;

import java.awt.Rectangle;

/*
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Ground extends Rectangle{
	
	public Ground(int x, int y, int width, int height){
		super.setBounds(x, y, width, height);
	}
}
