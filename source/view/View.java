package view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.dynamic.ResearcherImage;
import view.fixed.ChestImage;
import view.fixed.CollectibleImage;
import view.fixed.FactImage;
import view.fixed.GroundImage;
import view.fixed.HeartImage;
import view.fixed.PlatformImage;
import view.dynamic.BirdImage;
import view.dynamic.*;
import model.dynamic.*;
import model.fixed.Chest;
import model.fixed.Collectible;
import model.fixed.Fact;
import model.fixed.Ground;
import model.fixed.Platform;

/**
 * 
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 *
 *         Class in charge of drawing the images
 *         <p>
 *         The View class extends the JPanel that is later added to JFrame. This
 *         class holds JFrame frame for the JFrame object. The HashMap
 *         characterImages holds all {@link ImageObject} objects.
 *         researcherImage holds an image of the researcher. birdImage holds an
 *         image of the bird. It has a boolean animate variable used to
 *         increment the images. imgWidth and imgHeight determines the image
 *         dimensions. PlayerX and PlayerY contains the player's coordinates,
 *         with direct determining which way the player is facing.
 *         </p>
 * 
 */
public class View extends JPanel {

	// *************************************************
	// Fields

	private JFrame frame = new JFrame();
	// HashMap used for character change
	HashMap<String, ImageObject> characterImages = new HashMap<String, ImageObject>();
	// researcher image object that will be responsible in returning the researcher
	// image
	ResearcherImage researcherImage = new ResearcherImage();
	// bird image object responsible for bird image
	BirdImage birdImage = new BirdImage();
	// boolean determines player should animate
	boolean animate = false;
	// get the screen's dimensions
	final private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	final private double screenRatio = screenWidth / screenHeight;
	// player's x and y coordinates
	int playerX = 0;
	int playerY = 0;
	// player's starting direction and character
	int direct = 1;
	String playerCharacter = "researcher";
	// ground
	Ground ground;
	// for hearts display
	int health;
	ArrayList<HeartImage> hearts = new ArrayList<HeartImage>(3);
	// list of platforms
	ArrayList<Platform> platforms = new ArrayList<Platform>();
	// list of enemies
	ArrayList<Enemy> enemies;
	// list of collectibles & chests
	ArrayList<Collectible> collectibles;
	ArrayList<Collectible> collected;
	ArrayList<Fact> facts;
	ArrayList<Chest> chests;
	// fact show/not show
	boolean factTime;	
	// chest open/closed
	boolean chestStatus;
	// game modes
	boolean changeCharacterMode = false;
	boolean gameOverMode = false;
	// change character screen
	Image ChangeCharacterResearcher;
	Image ChangeCharacterBird;
	final private int ChangeCharacterMenuHeight = 500;
	final private int ChangeCharacterMenuWidth = 700;
	// game over screen
	Image GameOverScreen;
	final private int GameOverScreenHeight = (int) screenHeight - 100;
	final private int GameOverScreenWidth = (int) screenWidth - 100;
	final private int GameOverScreenXPos = 50;
	final private int GameOverScreenYPos = 25;
	final private int GameOverScoreXPos = 75;
	final private int GameOverScoreYPos = 275;
	final private int GameOverHighScoreXPos = 75;
	final private int GameOverHighScoreYPos = 400;
	// high-score fields
	public String highScore = "";
	public String score = "";
	// game time field
	private int gameTimeLeft;
	final private int GameTimeBarHeight = 35;
	final private int GameTimeBarWidth = 600;
	final private int GameTimeBarXPos = GameOverScreenWidth/2 - GameTimeBarWidth/2;
	final private int GameTimeBarYPos = 5;
	int dynamicTimeBar; 
	private boolean gameIntroMode = true;
	private int introSlideNumber;

	// *************************************************
	// Constructor

	/**
	 * Constructor used to create a view object
	 * <p>
	 * This constructor puts researcher image and bird image into the characterImage
	 * hashmap. Creates a JFrame object and sets the title, dimensions, visibility
	 * of the JFrame.
	 * </p>
	 */
	public View() {
		// grab all images
		characterImages.put("platform", new PlatformImage());
		characterImages.put("ground", new GroundImage());
		characterImages.put("greenCrab", new CrabImage());
		characterImages.put("osprey", new OspreyImage());
		characterImages.put("collectible", new CollectibleImage());
		characterImages.put("fact", new FactImage());
		characterImages.put("chest", new ChestImage());

		// set up background and add view object to the frame
		try {
			File file = new File("images/world/Background.jpg");
			BufferedImage img = ImageIO.read(file);
			BackgroundPanel background = new BackgroundPanel(img, BackgroundPanel.SCALED, 0.50f, 0.5f);
			frame.setContentPane(background);
			background.add(this);
		} catch (IOException except) {
			System.out.println("Cannot Read Image File: " + except);
			except.printStackTrace();
		}

		// set up the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Questary Alpha");
		// scale frame to screen's dimensions, and set location
		setSize(new Dimension((int) screenWidth, (int) screenHeight));
		frame.setSize(new Dimension((int) screenWidth, (int) screenHeight));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		// make frame visible
		frame.setVisible(true);

	}

	// *************************************************
	// Methods

	/**
	 * Draws the characters, ground, and platform on the screen
	 * 
	 * @param g
	 *            - Is a Graphics object that draws everything
	 */
	@Override
	public void paint(Graphics g) {
		dynamicTimeBar = 10*(gameTimeLeft/4);
		if (!changeCharacterMode && !gameOverMode && !gameIntroMode) {
			// paint score
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g.drawString("Score:" + score, (int) screenWidth - 200, 96);
			
			// paint timer bar
			g.setColor(Color.RED);
			g.fillRect(GameTimeBarXPos,GameTimeBarYPos, GameTimeBarWidth, GameTimeBarHeight);
			g.setColor(Color.BLUE);
			g.fillRect(GameTimeBarXPos,GameTimeBarYPos, dynamicTimeBar, GameTimeBarHeight);
			// paint character image
			if (playerCharacter == "researcher") {
				g.drawImage(researcherImage.show(direct), playerX, playerY, researcherImage.getWidth(),
						researcherImage.getHeight(), this);
			} else if (playerCharacter == "bird") {
				g.drawImage(birdImage.show(direct), playerX, playerY, birdImage.getWidth(), birdImage.getHeight(),
						this);
			}

			// paint enemies
			for (Enemy enemy : enemies) {
				ImageObject enemyImg = characterImages.get(enemy.getName());
				int direct = enemy.getDirection();
				g.drawImage(enemyImg.show(direct), (int) enemy.getX(), (int) enemy.getY(), (int) enemy.getWidth(),
						(int) enemy.getHeight(), this);
			}

			// paint ground
			g.setColor(Color.GRAY);
			g.fillRect((int) ground.getX(), (int) ground.getY(), (int) ground.getWidth(), (int) ground.getHeight());
			ImageObject groundImg = characterImages.get(ground.getName());
			g.drawImage(groundImg.show(0), (int) ground.getX(), (int) ground.getY(), (int) ground.getWidth(),
					(int) ground.getHeight(), this);

			// paint platform images
			for (Platform platform : platforms) {
				g.setColor(Color.GRAY);
				g.fillRect((int) platform.getX(), (int) platform.getY(), (int) platform.getWidth(),
						(int) platform.getHeight());
				ImageObject platformImg = characterImages.get(platform.getName());
				g.drawImage(platformImg.show(0), (int) platform.getX(), (int) platform.getY(),
						(int) platform.getWidth(), (int) platform.getHeight(), this);

			}

			// paint heart images
			for (int heart = 0; heart < health; heart++) {
				ImageObject heartImg = new HeartImage((int) (screenWidth - ((heart + 1) * 50)), 0);
				g.drawImage(heartImg.show(0), (int) (screenWidth - ((heart + 1) * 50)), 0, heartImg.getWidth(),
						heartImg.getHeight(), this);
			}

			// paint collectibles
			for (Collectible collectible : collectibles) {
				ImageObject collectibleImg = characterImages.get(collectible.getName());
				g.drawImage(collectibleImg.show(0), (int) collectible.getX(), (int) collectible.getY(),
						(int) collectible.getWidth(), (int) collectible.getHeight(), this);
			}

			// paint collected
			for (Collectible collectible : collected) {
				ImageObject collectedImg = characterImages.get(collectible.getName());
				g.drawImage(collectedImg.show(0), (int) collectible.getX(), (int) collectible.getY(),
						(int) collectible.getWidth(), (int) collectible.getHeight(), this);
			}
			
			// paint facts
			for (Fact fact : facts) {
				ImageObject factImg = characterImages.get(fact.getName());
				g.drawImage(factImg.show(Fact.getPicIter()), (int) fact.getX(), (int) fact.getY(), 
						(int) fact.getWidth(), (int) fact.getHeight(), this);
			}

			// paint chests
			for (Chest chest : chests) {
				ImageObject chestImg = characterImages.get(chest.getName());
				g.drawImage(chestImg.show(0), (int) chest.getX(), (int) chest.getY(), (int) chest.getWidth(),
						(int) chest.getHeight(), this);
				chestStatus = chest.getIsOpen();
			}
			

			// if game is in change character mode
		} else if (changeCharacterMode && !gameOverMode) {
			try {
				ChangeCharacterResearcher = ImageIO.read(new File("images/changeCharacter/Change_Researcher.png"));
				ChangeCharacterBird = ImageIO.read(new File("images/changeCharacter/Change_Bird.png"));
			} catch (IOException e) {
				System.out.println("Error with file upload");
				e.printStackTrace();
			}
			// if researcher is selected
			if (playerCharacter == "researcher") {
				g.drawImage(ChangeCharacterResearcher, (int) screenWidth / 2 - ChangeCharacterMenuWidth / 2,
						(int) screenHeight / 2 - ChangeCharacterMenuHeight / 2, ChangeCharacterMenuWidth,
						ChangeCharacterMenuHeight, this);
				// if bird is selected
			} else {
				g.drawImage(ChangeCharacterBird, (int) screenWidth / 2 - ChangeCharacterMenuWidth / 2,
						(int) screenHeight / 2 - ChangeCharacterMenuHeight / 2, ChangeCharacterMenuWidth,
						ChangeCharacterMenuHeight, this);
			}

			// if game is done
		} else if (gameOverMode) {
			try {
				GameOverScreen = ImageIO.read(new File("images/gameOver/Game_Over(1).png"));
			} catch (IOException e) {
				System.out.println("Error with file upload");
				e.printStackTrace();
			}

			g.drawImage(GameOverScreen, GameOverScreenXPos, GameOverScreenYPos, GameOverScreenWidth,
					GameOverScreenHeight, this);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 85));
			g.drawString("HIGHSCORE- "+ highScore, GameOverScoreXPos, GameOverHighScoreYPos);
			g.drawString("Your Score- " + score, GameOverScoreXPos, GameOverScoreYPos);
		}else if(gameIntroMode) {
			try {
				GameOverScreen = ImageIO.read(new File("images/IntroImages/Intro("+ introSlideNumber + ").png"));
			} catch (IOException e) {
				System.out.println("Error with file upload");
				e.printStackTrace();
			}

			g.drawImage(GameOverScreen, GameOverScreenXPos, GameOverScreenYPos, GameOverScreenWidth,
					GameOverScreenHeight, this);
		}
	}

	/**
	 * This method updates the View's player's coordinates, direction, and player's
	 * state. Afterwards it repaints the image.
	 * 
	 * @param playerX
	 *            - Player's x coordinate
	 * @param playerY
	 *            - Player's y coordinate
	 * @param direct
	 *            - Player's direction
	 * @param playerCharacter
	 *            - Player's state (researcher/bird)
	 */
	public void updateView(int playerX, int playerY, int direct, String playerCharacter, int healthLeft) {
		this.playerX = playerX;
		this.playerY = playerY;
		this.direct = direct;
		this.playerCharacter = playerCharacter;
		health = healthLeft;
		ImageObject platformImage = characterImages.get("platform");
		platformImage.nextImage(animate);
		ImageObject groundImage = characterImages.get("ground");
		groundImage.nextImage(animate);
		ImageObject greenCrabImage = characterImages.get("greenCrab");
		greenCrabImage.nextImage(animate);
		ImageObject ospreyImage = characterImages.get("osprey");
		ospreyImage.nextImage(animate);
		ImageObject collectibleImage = characterImages.get("collectible");
		collectibleImage.nextImage(animate);
		ImageObject factImage = characterImages.get("fact");
		factImage.nextImage(factTime);
		ImageObject chestImage = characterImages.get("chest");
		chestImage.nextImage(chestStatus);
		frame.repaint();
	}

	// *************************************************
	// Getters

	/**
	 * Getter for the frame of the View
	 * 
	 * @return JFrame - the frame in the view
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Getter for the user's name
	 * 
	 * @return String - name of the user
	 */
	public String getName() {
		return JOptionPane.showInputDialog("You set a new highscore. What is your name?");
	}

	// *************************************************
	// Setters

	/**
	 * Sets the Intro slide number to display
	 * 
	 * @param introSlideNumber - 
	 * 						sets the slide number to display
	 */
	public void setIntroSlideNumber(int introSlideNumber) {
		this.introSlideNumber = introSlideNumber;
	}
	
	/**
	 * Set game to and from intro mode
	 * 
	 */
	public void setIntroMode(boolean b) {
		gameIntroMode = b;
	}
	
	/**
	 * This method sets game view into change character mode
	 * 
	 */
	public void changeCharacterMode() {
		changeCharacterMode = !changeCharacterMode;
	}

	/**
	 * This method sets game view into game over mode
	 * 
	 */
	public void gameOverMode() {
		gameOverMode = true;
	}

	/**
	 * Sets the game High Score
	 * 
	 * @param highScore
	 *            - Sets the highScore to String highScore
	 */
	public void setHighScore(String highScore) {
		this.highScore = highScore;
	}

	/**
	 * Sets the players current Score
	 * 
	 * @param score
	 *            - Sets the score to String score
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * Sets the current GameTime
	 * 
	 * @param score
	 *            - Sets the score to String score
	 */
	public void setGameTime(int gameTimeLeft) {
		this.gameTimeLeft = gameTimeLeft;
	}

	/**
	 * After seeing if the character is a bird or researcher, it will increment the
	 * researcher or bird image. It will only increment if animate is true\
	 * 
	 * @see ResearcherImage#nextImage(boolean)
	 * @see BirdImage#nextImage(boolean)
	 */
	public void setPicNum() {
		if (playerCharacter == "researcher") {
			researcherImage.nextImage(animate);
		} else if (playerCharacter == "bird") {
			birdImage.nextImage(animate);
		}

	}

	/**
	 * Determines if the player should be animated or not. If animate is false then
	 * there would be not animation.
	 * 
	 * @param b
	 *            - Sets the animate value to boolean b
	 */
	public void setAnimation(boolean b) {
		animate = b;
	}

	/**
	 * Sets the View.platform1 to the playerform1 passed in, to be drawn by another
	 * method
	 * 
	 * @param platform1
	 *            - The platform the player will be interacting with
	 */
	public void setPlatforms(ArrayList<Platform> platformList) {
		platforms = platformList;
	}

	/**
	 * Sets the View.ground to the ground passed in, to be drawn in another method
	 * 
	 * @param ground
	 *            - The ground the player will be standing on
	 */
	public void setGroundImage(Ground ground) {
		this.ground = ground;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public void setCollectibles(ArrayList<Collectible> collectibles) {
		this.collectibles = collectibles;
	}

	public void setCollected(ArrayList<Collectible> collected) {
		this.collected = collected;
	}
	
	public void setFacts(ArrayList<Fact> facts) {
		this.facts = facts;
	}

	public void setChests(ArrayList<Chest> chests) {
		this.chests = chests;
	}
}
