package Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Agent;

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
	public static List<Agent> agents;
	public static int nbFish=0;

	public Environement(int SizeX, int SizeY) {
		gridSizeX = SizeX;
		gridSizeY = SizeY;
		gridXY = new int[gridSizeX][gridSizeY];
		// billesInGrid = new Bille[gridSizeX][gridSizeY];
	}

	/**
	 * Add billes and initialize them with first positions
	 * 
	 * @param Agents
	 *            the list of billes which need to be initialized
	 */
	@SuppressWarnings("static-access")
	public void addAndInitBilles(List<Agent> Agents) {
		this.agents = Agents;
		List<Integer> xList = new ArrayList<Integer>();
		List<Integer> yList = new ArrayList<Integer>();

		int x = 0, y = 0;
		Random rand = new Random();
		for (int i = 0; i < Agents.size(); i++) {
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

		for (int i = 0; i < Agents.size(); i++) {
			Agent agent = Agents.get(i);
			agent.setXY(xList.get(i), yList.get(i));
			gridXY[agent.getX()][agent.getY()] = 1;
			nbFish++;
		}
	}

	/**
	 * get a particle which is at the appointed position
	 * 
	 * @param theX
	 *            the position of abscissa
	 * @param theY
	 *            the position of ordinate
	 * @return a particle
	 */
	public static Agent getAgent(int theX, int theY) {
		for (Agent agent : agents) {
			if (agent.getX() == theX && agent.getY() == theY) {
				return agent;
			}
		}
		return null;
	}

	public static void addAgent(Agent agent, int xBaby, int yBaby) {
		agent.setXY(xBaby, yBaby);
		gridXY[agent.getX()][agent.getY()] = 1;		
	}
	
}
