package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Model;
import model.sprites.dynamic.Player;

public class View extends JPanel{
	
	private JFrame frame;
	//fields related to pictures
	final int frameCount = 10;
	int picNum = 0;
	BufferedImage[][] pics;
	
	//boolean determines player should animate
	boolean animate = false;
	
	private int imgWidth;
	private int imgHeight;
	
	int direction = Model.getPlayerDirection();
	double playerX = Model.getStartingX();
	double playerY = Model.getStartingY();
	
	//ground 
	Rectangle ground;
	
	public View(double playerX, double playerY, int width, int height, int direct, String playerCharacter) {
		this.playerX = (int)playerX;
		this.playerY = (int)playerY;
		this.imgWidth = width;
		this.imgHeight = height;
		this.direction = direct;
		
		//load in the cat images
		pics = new BufferedImage[2][10];
		
		frame = new JFrame();
		
		//load in the images
		for (int i = 0; i < frameCount; i++) {
			BufferedImage image = createImage("images/" + playerCharacter + "/Walk (" + (i+1) + ")" + ".png");
			pics[1][i] = image;
		}
		
		for (int i = 0; i < frameCount; i++) {
			pics[0][i] = flip(pics[1][i]);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Questary Alpha");
		
		frame.setSize(new Dimension(Model.getScreenHeight(), Model.getScreenWidth()));
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.getContentPane().add(this);
		frame.setVisible(true);
	}
	
  	//the String imageFile is the file name
	private BufferedImage createImage(String imageFile) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imageFile));
			return bufferedImage;
		} catch (IOException except) {
			System.out.println("Error with file upload");
			except.printStackTrace();		
		}
		return null;
	}
	
	private BufferedImage flip(BufferedImage image) {
		 int width = image.getWidth();
		 int height = image.getHeight();
		 
		 BufferedImage mimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		 for(int y = 0; y < height; y++) {
			 for(int lx = 0, rx = width-1; lx < width; lx++, rx--)
			 {
				 int p = image.getRGB(lx, y);
				 mimg.setRGB(rx, y, p);
			 }
		 }
		 return mimg;
	}
	

	// Override the JPanel's paint method
	@Override
	public void paint(Graphics graphic) {
		picNum = modPicNum();		
		graphic.setColor(Color.blue);
		graphic.fillRect((int)playerX, (int)playerY, imgWidth, imgHeight);
		
		graphic.drawImage(pics[direction][picNum], (int)playerX, (int)playerY, imgWidth, imgHeight, this);
		
		graphic.setColor(Color.gray);
		graphic.fillRect((int)ground.getX(), (int)ground.getY() + imgHeight, (int)ground.getWidth(), (int)ground.getHeight());
	}
	
/*	//Override the JPanel's paint method
	@Override
	public void paint(Graphics graphic) {
		picNum = modPicNum();	
		graphic.drawImage(pics[Player.getDirection()][picNum], Model.getPlayerX(), Model.getPlayerY(), imgWidth, imgHeight, this);
		graphic.fillRect((int)ground.getX(), (int)ground.getY() + imgHeight, (int)ground.getWidth(), (int)ground.getHeight());
	}*/
	
	//update the data and repaint the image
	public void updateView(double playerX, double playerY, int width, int height, int direct, String playerCharacter){ 
		this.playerX = (int)playerX;
		this.playerY = (int)playerY;
		this.imgWidth = width;
		this.imgHeight = height;
		this.direction = direct;
		frame.repaint();		
	} 

	//mod picNum by frameCount
	public int modPicNum() {
		if(animate) {
			picNum = (picNum + 1) % frameCount;
		}
		return picNum;
	} 
  
	//getter for the frame
	public JFrame getFrame() {
		return frame;
	}
	 

	public int getImgWidth() {
		return imgWidth;
	}
	
	//setter for the ground
	public void setGroundImage(Rectangle ground){
		this.ground = ground;
	}
	
	//setter for animation
	public void setAnimation(boolean bool) {
		animate = bool;
	}
  
}
