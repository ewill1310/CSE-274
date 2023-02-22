/**
 * Written By Evan Williams
 */
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * creates the abstract class Enemy
 * @author Evan Williams
 *
 */
public abstract class Enemy extends JComponent{

	/**
	 * creates method paintComponent for child classes to use
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	/**
	 * creates the abstract method processCollision for children classes
	 * @param enemyList
	 * @param i
	 */
	protected abstract void processCollision(ArrayList<Enemy> enemyList, int i);
	
	/**
	 * creates the abstract method setX() for children classes
	 * @param i
	 */
	protected abstract void setX(int i);
	
	/**
	 * creates the abstract method setY() for children classes
	 * @param i
	 */
	protected abstract void setY(int i);
	
	/**
	 * creates the abstract method getX() for children classes
	 */
	public abstract int getX();
	
	/**
	 * creates the abstract method getY() for children classes
	 */
	public abstract int getY();
	
	/**
	 * Creates the abstract method moveLeft for children classes
	 * @return
	 */
	protected abstract boolean moveLeft();
	
	/**
	 * Creates the abstract method moveRight for children classes
	 * @return
	 */
	protected abstract boolean moveRight();
	
	/**
	 * Creates the abstract method getLeft for children classes
	 * @return
	 */
	protected abstract boolean getLeft();

	
	
}
