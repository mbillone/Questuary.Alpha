package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.dynamic.CatImage;
import view.dynamic.DogImage;
import view.dynamic.ImageObject;
/**
 * Class in charge of drawing the images
 * <p>
 * The View class extends the JPanel that is later added to JFrame.
 * This class holds JFrame frame for the JFrame object. The HashMap characterImages holds all ImageObject objects. 
 * CatImage holds an image of the cat. DogImage holds an image of the dog. It has a boolean animate variable used to increment the images.
 * imgWidth and imgHeight determines the image dimensions. PlayerX and PlayerY contains the player's coordinates, with direct determining 
 * which way the player is facing. The Rectangle ground and platform help draw the ground and platform.
 * @author David Chan, Akash Sharma
 *
 */
public class View extends JPanel{
	
	private JFrame frame;
	//HashMap used for character change
	HashMap<String,ImageObject>characterImages = new HashMap<String,ImageObject>();
	
	//Cat image object that will be responsible in returning the cat image
	CatImage catImage = new CatImage();
	//Dog image object responsible for dog image
	DogImage dogImage = new DogImage();
	
	//boolean determines player should animate
	boolean animate = false;
	
	///get screen's dimensions
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	double ratio = screenWidth/screenHeight; 
	private int imgWidth;
	private int imgHeight;


	//player's x and y coordinates
	int playerX = 0;
	int playerY = 0;
	//player's direction
	int direct = 1;
	//ground 
	Rectangle ground;
	Rectangle platform1;
	String playerCharacter = "cat";
	//******************
	//Constructor
	
	/**
	 * Constructor used to create a view object
	 * <p>
	 * This constructor puts cat image and dog image into the characterImage hashmap.
	 * Creates a JFrame object and sets the title, dimensions, visibility of the JFrame.
	 * 
	 * @param none
	 */
	
	public View(){
		
		characterImages.put("cat", catImage);
		characterImages.put("dog", dogImage);
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Questary Alpha");
		
		frame.setSize(new Dimension((int)screenWidth,(int)screenHeight));
		setSize(new Dimension((int)screenWidth, (int)screenHeight));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(this);
		frame.setVisible(true);
		
	}
	  /**
	   * Returns the frame of the View 
	   * @param none
	   * @return the JFrame frame in the view
	   * @see JFrame
	   */
	 //getter for the frame
	 public JFrame getFrame(){
		 return frame;
	 }
	 
	  /**
	   * Returns the player image's width 
	   * @param none
	   * @return the image's width
	   * @see int
	   */
	 public int getImgWidth() {
		return imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}
	 
	//setter for the ground
	public void setGroundImage(Rectangle ground){ 
		this.ground = ground;
	}
	
	public void setPlatformImage(Rectangle platform1) {
		this.platform1 = platform1;
	}
	
	//setter for picNum
	public void setPicNum(){
		if(playerCharacter == "cat") {
			catImage.nextImage(animate);
		}else if(playerCharacter == "dog") {
			dogImage.nextImage(animate);
		}
		
	}
	
	//setter for animation
	public void setAnimation(boolean b){
		animate = b;
	}
	
	 //Override the JPanel's paint method
	 @Override
	 public void paint(Graphics g){
		 g.setColor(Color.blue);
		 g.fillRect(playerX, playerY,imgWidth,imgHeight);
		 if(playerCharacter == "cat") {
			 g.drawImage(catImage.show(direct), playerX, playerY, catImage.getWidth(), catImage.getHeight(),this);
		 }else if(playerCharacter =="dog") {
			 g.drawImage(dogImage.show(direct), playerX, playerY, dogImage.getWidth(), dogImage.getHeight(),this);
		 }
		

		 g.setColor(Color.gray);
		 g.fillRect((int)ground.getX(), (int)ground.getY(), (int)ground.getWidth(), (int)ground.getHeight());
		 g.fillRect((int)platform1.getX(), (int) platform1.getY(), (int) platform1.getWidth(), (int) platform1.getHeight());
	 }
	 
	//update the data and repaint the image
	public void updateView(int playerX, int playerY, int direct, String playerCharacter){ 
		this.playerX = playerX;
		this.playerY = playerY;
		this.direct = direct;
		this.playerCharacter = playerCharacter;
		frame.repaint();		
	}
		
}
