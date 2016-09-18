package particules;

import java.awt.Color;
import Environment.Environement;
import core.Agent;
import core.Direction;

public class Fishs extends Agent {

	private int x, y;
	private int cpt;
	private int breedTime;
	private Direction dir;
	private int xNext = this.getX() + this.getPasX();
	private int yNext = this.getY() + this.getPasY();

	public Fishs() {
		this.color = Color.blue;
		this.dir = new Direction();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getPasX() {
		return this.dir.pasX;
	}

	@Override
	public int getPasY() {
		return this.dir.pasY;
	}

	public boolean move() {
		int[][] neighbor = getNeighbor();

		// if the fish is surrounded by 8 grid.
		if ((xNext > 0) && (xNext < Environement.gridSizeX - 1) && (0 < yNext)
				&& (yNext < Environement.gridSizeY - 1)) {
			if (neighbor.length < 8) {// when there are some blanks
				while (Environement.gridXY[xNext][yNext] != 0) {
					xNext = this.getX();
					yNext = this.getY();
					this.setPasXY(new Direction().pasX, new Direction().pasY);
					xNext = this.getX() + this.getPasX();
					yNext = this.getY() + this.getPasY();
				}
				usePostion(xNext, yNext);
				return false;
			} else {
				xNext = this.getX();
				yNext = this.getY();
				usePostion(xNext, yNext);
				return false;
			}
		} else {
			if (this.getX() == 0 || this.getX() == Environement.gridSizeX - 1) {
				this.setPasXY(-getPasX(), getPasY());
			} else if (this.getY() == 0
					|| this.getY() == Environement.gridSizeY - 1) {
				this.setPasXY(getPasX(), -getPasY());
			}
			xNext += 2 * this.getPasX();
			yNext += 2 * this.getPasY();
			// the fish is at the edge of the view
			if (neighbor.length < 3) {
				while ((xNext < 0) || (xNext > Environement.gridSizeX - 1)
						|| (0 > yNext) || (yNext > Environement.gridSizeY - 1)
						|| Environement.gridXY[xNext][yNext] != 0) {
					xNext = this.getX();
					yNext = this.getY();
					this.setPasXY(new Direction().pasX, new Direction().pasY);
					xNext = this.getX() + this.getPasX();
					yNext = this.getY() + this.getPasY();
				}
				usePostion(xNext, yNext);
				return false;
			} else if (3 < neighbor.length
					&& neighbor.length < 5
					&& (0 < this.getX()
							|| this.getX() < Environement.gridSizeX - 1
							|| 0 < this.getY() || this.getY() < Environement.gridSizeY - 1)) {
				while ((xNext < 0) || (xNext > Environement.gridSizeX - 1)
						|| (0 > yNext) || (yNext > Environement.gridSizeY - 1)
						|| Environement.gridXY[xNext][yNext] != 0) {
					xNext = this.getX();
					yNext = this.getY();
					this.setPasXY(new Direction().pasX, new Direction().pasY);
					xNext = this.getX() + this.getPasX();
					yNext = this.getY() + this.getPasY();
				}
				usePostion(xNext, yNext);
				return false;
			}
			xNext = this.getX();
			yNext = this.getY();
			usePostion(xNext, yNext);
			return false;
		}
	}

	private int[][] getNeighbor() {
		int[][] neighbor = new int[3][3];

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (Environement.gridXY[this.getX() + i][this.getY() + j] == 1) {
					neighbor[i + 1][i + 1] = 1;
				}
			}
		}
		neighbor[1][1] = 0;
		return neighbor;
	}

	// problem of counting the number of fish and the cpt of the baby fish must
	// be 0, can't use random
	@Override
	public void decide() {
		move();
		if (this.cpt >= this.breedTime
				&& (this.getX() != this.xNext || this.getY() != this.yNext)) {
			int xBaby = this.x;
			int yBaby = this.y;

			Fishs fish = new Fishs();
			fish.setXY(xBaby, yBaby);
			Environement.addAgent(fish, xBaby, yBaby);
			this.cpt = 0;
		} else {
			this.cpt++;
		}
	}

	@Override
	public void usePostion(int theX, int theY) {
		Environement.gridXY[theX][theY] = 1;
	}

	@Override
	public void freePosition(int theX, int theY) {
		Environement.gridXY[theX][theY] = 0;
	}

	@Override
	public void setXY(int theX, int theY) {
		this.x = theX;
		this.y = theY;
	}

	@Override
	public void setPasXY(int thePasX, int thePasY) {
		this.dir.pasX = thePasX;
		this.dir.pasY = thePasY;
	}

}
