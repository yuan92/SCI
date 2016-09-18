package Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Agent.Bille;

/**
 * the environment of the particles
 *
 */
public class Environement {
	public static int gridSizeX;
	public static int gridSizeY;
	public static int[][] gridXY;// This matrice contains 0 or 1, 0: position xy
									// hasn't been used by a bille, 1: position
									// xy has been used by a bille
	// public static Bille[][] billesInGrid;
	public static List<Bille> billes;

	public Environement(int SizeX, int SizeY) {
		gridSizeX = SizeX;
		gridSizeY = SizeY;
		gridXY = new int[gridSizeX][gridSizeY];
		// billesInGrid = new Bille[gridSizeX][gridSizeY];
	}

	/**
	 * Add billes and initialize them with first positions
	 * 
	 * @param billes
	 *            the list of billes which need to be initialized
	 */
	@SuppressWarnings("static-access")
	public void addAndInitBilles(List<Bille> billes) {
		this.billes = billes;
		List<Integer> xList = new ArrayList<Integer>();
		List<Integer> yList = new ArrayList<Integer>();

		int x = 0, y = 0;
		Random rand = new Random();
		for (int i = 0; i < billes.size(); i++) {
			boolean xNotFound = true;
			while (xNotFound) {
				x = rand.nextInt(gridSizeX);
				if (xList.contains(x)) {
					continue;
				} else {
					xList.add(x);
					break;
				}
			}

			boolean yNotFound = true;
			while (yNotFound) {
				y = rand.nextInt(gridSizeY);
				if (yList.contains(y)) {
					continue;
				} else {
					yList.add(y);
					break;
				}
			}
		}

		for (int i = 0; i < billes.size(); i++) {
			Bille bille = billes.get(i);
			bille.setXY(xList.get(i), yList.get(i));

			gridXY[bille.getX()][bille.getY()] = 1;
			// billesInGrid[bille.getX()][bille.getY()] = bille;
		}
	}

	/**
	 * get the bille which is at the appointed position
	 * 
	 * @param theX
	 *            the position of abscissa
	 * @param theY
	 *            the position of ordinate
	 * @return a bille
	 */
	public static Bille getBille(int theX, int theY) {
		for (Bille bille : billes) {
			if (bille.getX() == theX && bille.getY() == theY) {
				return bille;
			}
		}
		return new Bille();
	}
}
