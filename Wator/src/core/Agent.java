package core;

import java.awt.Color;

/**
 * 
 * abstract class, define some method
 *
 */
public abstract class Agent {
	
	public Color color;
	/**
	 * @return the position of abscissa
	 */
	public abstract int getX();

	/**
	 * 
	 * @return the position of ordinate
	 */
	public abstract int getY();

	/**
	 * 
	 * @return the direction in abscissa
	 */
	public abstract int getPasX();

	/**
	 * 
	 * @return the direction in ordinate
	 */
	public abstract int getPasY();

	/**
	 * determine the process of the particles
	 */
	public abstract void decide();

	/**
	 * marker the position is used
	 * 
	 * @param theX
	 *            the position of abscissa
	 * @param theY
	 *            the position of ordinate
	 */
	public abstract void usePostion(int theX, int theY);

	/**
	 * marker the position is free
	 * 
	 * @param theX
	 *            the position of abscissa
	 * @param theY
	 *            the position of ordinate
	 */
	public abstract void freePosition(int theX, int theY);

	/**
	 * set the position for a particle
	 * 
	 * @param theX
	 *            the position of abscissa
	 * @param theY
	 *            the position of ordinate
	 */
	public abstract void setXY(int theX, int theY);

	/**
	 * set the direction for a particle
	 * 
	 * @param thePasX
	 *            the position of abscissa
	 * @param thePasY
	 *            the position of ordinate
	 */
	public abstract void setPasXY(int thePasX, int thePasY);

}
