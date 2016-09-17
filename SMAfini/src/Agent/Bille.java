package Agent;

import Environment.Environement;

/**
 * 
 * contain the characteristics of the particle
 *
 */
public class Bille extends Agent {
	private int x;// 1, 2, 3, ...
	private int y;
	private Direction dir;

	public Bille() {
		this.dir = new Direction();
	}

	public boolean move() {
		boolean conflict = false;
		if ((x + dir.pasX >= 0 && x + dir.pasX < Environement.gridSizeX
				&& y + dir.pasY >= 0 && y + dir.pasY < Environement.gridSizeY)
				&& Environement.gridXY[x + dir.pasX][y + dir.pasY] == 1) {

			Bille otherBille = Environement
					.getBille(x + dir.pasX, y + dir.pasY);
			int tempPasX = otherBille.getPasX();
			int tempPasY = otherBille.getPasY();
			otherBille.setPasXY(dir.pasX, dir.pasY);
			setPasXY(tempPasX, tempPasY);
			return false;
		}
		if (x + dir.pasX < 0 || x + dir.pasX >= Environement.gridSizeX) {
			dir.pasX = -dir.pasX;
			conflict = true;
		}
		if (y + dir.pasY < 0 || y + dir.pasY >= Environement.gridSizeY) {
			dir.pasY = -dir.pasY;
			conflict = true;
		}
		if (!conflict) {
			freePosition(x, y);
			x = x + dir.pasX;
			y = y + dir.pasY;
			usePostion(x, y);
		}
		if (conflict) {
			return false;
		} else {
			return true;
		}
	}

	public void decide() {
		move();
	}

	public void usePostion(int theX, int theY) {
		Environement.gridXY[theX][theY] = 1;
		// EnvBille.billesInGrid[x][y] = this;
	}

	public void freePosition(int theX, int theY) {
		Environement.gridXY[theX][theY] = 0;
		// EnvBille.billesInGrid[x][y] = null;
	}

	public void setXY(int theX, int theY) {
		x = theX;
		y = theY;
	}

	public void setPasXY(int thePasX, int thePasY) {
		dir.pasX = thePasX;
		dir.pasY = thePasY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPasX() {
		return dir.pasX;
	}

	public int getPasY() {
		return dir.pasY;
	}

	public String toString() {
		return "there is a bille is at the position (" + this.getX() + " , "
				+ this.getY() + " ), and his direction in abscissa is "
				+ this.getPasX() + ", his direction in ordinate is "
				+ this.getPasY();
	}
}