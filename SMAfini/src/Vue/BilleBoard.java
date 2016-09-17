package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class BilleBoard extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	public static final int MARGIN = 20;
	public static int GRID_SPAN;
	private int rows;
	private int cols;
	private List<Point> newBillePointList;
	@SuppressWarnings("unused")
	private Color colortemp;

	public BilleBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.setSize(1000, 1000);
		GRID_SPAN = (getWidth() - MARGIN * 2) / this.rows;
		newBillePointList = new ArrayList<>();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i <= this.rows; i++) {
			g.drawLine(MARGIN, MARGIN + i * GRID_SPAN, MARGIN + this.cols
					* GRID_SPAN, MARGIN + i * GRID_SPAN);
		}
		for (int i = 0; i <= this.cols; i++) {
			g.drawLine(MARGIN + i * GRID_SPAN, MARGIN, MARGIN + i * GRID_SPAN,
					MARGIN + this.rows * GRID_SPAN);

		}
		if (this.newBillePointList != null) {
			for (int i = 0; i < this.newBillePointList.size(); i++) {
				int x = this.newBillePointList.get(i).getX();
				int y = this.newBillePointList.get(i).getY();

				g.setColor(this.newBillePointList.get(i).getColor());
				g.fillOval(x - Point.DIAMETER / 2, y - Point.DIAMETER / 2,
						Point.DIAMETER, Point.DIAMETER);
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object newBillesPoints) {
		this.newBillePointList = (List<Point>) newBillesPoints;
		this.repaint();
	}

}
