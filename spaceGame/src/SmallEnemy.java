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
 * The Small enemy class that extends the Enemy abstract class
 * @author Evan Williams
 *
 */
public class SmallEnemy extends Enemy{
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image enemyImage = t.getImage("src/SmallEnemy.png");
	private int x = 500;
	private int y = 100;
	private boolean left = true;

	/**
	 * constructor for the small enemy class
	 */
	public SmallEnemy() {

	}
	
	/**
	 * Full Constructor for the small enemy class
	 * @param x
	 * @param y
	 */
	public SmallEnemy(int x, int y) {
		this.x = x+50;
		this.y = y;
	}
	
	/**
	 * Paints the Small enemies
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(enemyImage, x, y, this);
	}

	/**
	 * moves the enemy left if it can and returns a boolean value
	 */
	public boolean moveLeft() {
		if (x >= 10) {
			x = x - 5;
			repaint();
			return true;
		}
		left = false;
		return false;
	}

	/**
	 * moves the enemy right if it can and returns a boolean value
	 */
	public boolean moveRight() {
		if (x <= 740) {
			x = x + 5;
			repaint();
			return true;
		}
		left = true;
		return false;
	}
	
	/**
	 * returns the boolean status of if the SmallEnemy can move left
	 */
	public boolean getLeft(){
		return left;
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
	 * sets the x position of the Small Enemy
	 */
	@Override
	protected void setX(int i) {
		this.x=i;
	}

	/**
	 * sets the y position of the Small Enemy
	 */
	@Override
	protected void setY(int i) {
		this.y=i;
	}

	/**
	 * returns the x position of the Small Enemy
	 */
	@Override
	public int getX() {
		return x;
	}

	/**
	 * returns the y position of the Small Enemy
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Creates a rectangle hitbox of the enemy to be checked with other collisions
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 75);
	}
}
