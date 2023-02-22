/**
 * Written By Evan Williams
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * The Big enemy class that extends the Enemy abstract class
 * @author Evan Williams
 *
 */
public class BigEnemy extends Enemy{
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image enemyImage = t.getImage("src/largeEnemy.png");
	private int x = 300;
	private int y = 250;
	private boolean left = false;

	/**
	 * constructor for Big Enemy class
	 */
	public BigEnemy() {

	}
	
	/**
	 * Constructor for big enemy class and places it in a certain locations
	 * @param x
	 * @param y
	 */
	public BigEnemy(int x, int y) {
		this.x = x+50;
		this.y = y;
	}

	/**
	 * paints the big enemy
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(enemyImage, x, y, this);
	}

	/**
	 * moves the enemy left if it can and returns a boolean status
	 */
	public boolean moveLeft() {
		if (x >= 10) {
			x = x - 10;
			repaint();
			return true;
		}
		left = false;
		return false;
	}

	/**
	 * moves the enemy right if it can and returns a boolean status
	 */
	public boolean moveRight() {
		if (x <= 740) {
			x = x + 10;
			repaint();
			return true;
		}
		left = true;
		return false;
	}
	
	/**
	 * returns the boolean value of if the enemy is moving or can move left
	 */
	public boolean getLeft(){
		return left;
	}
	
	/**
	 * sets the boolean value of Left for the enemy
	 * @param left
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	/**
	 * sets the x position of the big enemy
	 */
	public void setX(int i) {
		this.x=i;
	}
	
	/**
	 * sets the y position of the big enemy
	 */
	public void setY(int i) {
		this.y=i;
	}
	
	/**
	 * Moves the enemy and "kills" them
	 */
	@Override
	protected void processCollision(ArrayList<Enemy> enemyList, int i) {
		enemyList.get(i).setX(-500);
		enemyList.get(i).setY(-75);
		enemyList.remove(i);
	}
	
	/**
	 * returns the current X position of the Big Enemy
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * returns the current Y position of the Big Enemy
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	/**
	 * Creates a rectangle hitbox of the enemy to be checked with other collisions
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 75);
	}
}
