package view.dynamic;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.dynamic.ImageObject;

public class CatImage extends ImageObject{
	
	//2D array for the images
	private BufferedImage[][] pics = new BufferedImage[2][10];
	
	//************************
	//Constructor
	public CatImage(){
		
		super.setWidth((int)(getScreenWidth() * 0.1));
		super.setHeight((int)(getWidth() * getRatio()));
		super.setFrameCount(10);
		
		//create the 2D array
		super.setPicsArray(2);
		
		//load in the images
		for (int i = 0; i < super.getFrameCount(); i++)
		{
			BufferedImage image = createImage("images/cat/Walk (" + (i+1) + ")" + ".png");
			super.setImage(1, i, image);
			pics[1][i] = image;
		}
		
		for (int i = 0; i < super.getFrameCount(); i++)
		{
			pics[0][i] = flip(pics[1][i]);
		}
	}
	
	//********************
	//Methods
	
	 //The String imageFile is the input to the method, and is the file name
	 private BufferedImage createImage(String imageFile){
	  BufferedImage bufferedImage;
	  try {
	  		bufferedImage = ImageIO.read(new File(imageFile));
	  		return bufferedImage;
	  	} catch (IOException e) {
	  		System.out.println("Error with file upload");
	  		e.printStackTrace();
	  	}
	  return null;
	 }
	 
	 //method used to flip the image
	 private BufferedImage flip(BufferedImage image){
		 int width = image.getWidth();
		 int height = image.getHeight();
		 
		 BufferedImage mimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		 for(int y = 0; y < height; y++)
		 {
			 for(int lx = 0, rx = width-1; lx < width; lx++, rx--)
			 {
				 int p = image.getRGB(lx, y);
				 mimg.setRGB(rx, y, p);
			 }
		 }
		 return mimg;
	 }

	 //increment through the CatImage 
	 public void nextImage(boolean canAnimate){
		 if(canAnimate)
		 {
			 int num = super.getPicNum();
			 num = (num + 1)%super.getFrameCount();
			 super.setPicNum(num);
		 }
	 }
	 
	 //return the image in the array
	 public BufferedImage show(int direct){
		 return pics[direct][super.getPicNum()];
	 }
	 
}
