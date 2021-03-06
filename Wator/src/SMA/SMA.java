package SMA;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import particules.Fishs;
import core.Agent;
import Environment.Environement;
import Vue.BilleBoard;
import Vue.Point;
import Vue.Vue;

/**
 * performer the turn
 *
 */
public class SMA extends Observable implements Runnable {

	private List<Observer> observers;
	public List<Point> newBillePointList;
	private String sizeX, sizeY, nbBilles;
	private Environement env;
	private List<Color> colors;
	public int nbFish;

	public SMA(String sizeX, String sizeY, String nbBilles) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBilles = nbBilles;

		observers = new ArrayList<>();
		newBillePointList = new ArrayList<>();
		env = new Environement(Integer.valueOf(this.sizeX),
				Integer.valueOf(this.sizeY));
		this.addObserver(Vue.billeBoard);

		colors = new ArrayList<Color>();
		for (int i = 0; i < Integer.valueOf(this.nbBilles); i++) {
			while (true) {
				Random ran = new Random();
				int r = ran.nextInt(255);
				int g = ran.nextInt(255);
				int b = ran.nextInt(255);
				Color col = new Color(r, g, b);

				if (!colors.contains(col)) {
					colors.add(col);
					break;
				} else {
					continue;
				}
			}
		}
	}

	public void run() {

		if (Integer.valueOf(nbBilles) >= Integer.valueOf(sizeX)
				* Integer.valueOf(sizeY)) {
			System.out.println("Billes number impossible !");
			return;
		}

		List<Agent> agent = new ArrayList<>();
		for (int i = 0; i < Integer.valueOf(nbBilles); i++) {
			agent.add(new Fishs());
		}

		env.addAndInitBilles(agent);// Init Billes' positions

		// Init Billes' directions
		/*
		 * for(int i=0; i<billes.size(); i++){ billes.get(i).initDirection(); }
		 */

		System.out.println("Billes initiation succeed !");
		showBillesState(agent);// For trace

		@SuppressWarnings("unused")
		long maxSearchTime = 20;// 10s
		long startTime = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) { // nombre de ticks
			for (int i = 0; i < agent.size(); i++) {
				agent.get(i).decide();
			}

			// To map billes' positions on BilleBoard
			List<Point> billePointList = new ArrayList<>();
			for (int i = 0; i < agent.size(); i++) {
				int x = BilleBoard.MARGIN + BilleBoard.GRID_SPAN / 2
						+ (agent.get(i).getX()) * BilleBoard.GRID_SPAN;
				int y = BilleBoard.MARGIN + BilleBoard.GRID_SPAN / 2
						+ (agent.get(i).getY()) * BilleBoard.GRID_SPAN;

				Point p = new Point(x, y, this.colors.get(i));
				billePointList.add(p);
			}
			this.newBillePointList = billePointList;

			this.setChanged();
			showBillesState(agent);// For trace
			this.notifyObservers();

		}
		double executionTime = (System.currentTimeMillis() - startTime) / 1000.0;
		System.out.println("average time of  tick : " + executionTime / 100.0);

	}

	public void addObserver(Observer ob) {
		this.observers.add(ob);
	}

	public void notifyObservers() {
		for (Observer ob : this.observers) {
			ob.update(this, this.newBillePointList);
		}
	}

	public void setChanged() {
		System.out
				.println("Billes have changed their positions randomly, and there is the new list of positions of billes !");
	}

	private void showBillesState(List<Agent> agent) {
		for (int i = 0; i < agent.size(); i++) {
			System.out.println(agent.get(i).toString());
		}
	}
	
	public  void setNbFish(int i){
		this.nbFish=i;
	}
	public  int getNbFish(){
		return this.nbFish;
	}
	
}
