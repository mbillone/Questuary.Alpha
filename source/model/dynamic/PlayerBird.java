package model.dynamic;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class PlayerBird extends Player {

	// *************************************************
	// Constructor

	/**
	 * Constructor for the bird character for the player
	 * @param xCoord - x coordinate of the player
	 * @param yCoord - y coordinate of the player
	 * @param width - width of the character model
	 * @param height - height of the character model
	 * @param gravity - gravity value on the player
	 */
	public PlayerBird(int xCoord, int yCoord, int width, int height, int gravity) {
		super(xCoord, yCoord, width, height, gravity);
	}

}
