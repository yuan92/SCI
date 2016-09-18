package Vue;

import java.awt.Color;
/**
 * the position of the particle in the view
 *
 */
public class Point {
  private int x;
  private int y;
  private Color color;
  public static final int DIAMETER=BilleBoard.GRID_SPAN;
  
  public Point(int x,int y,Color color){
	  this.x=x;
	  this.y=y;
	  this.color=color;
  } 
  
  public int getX(){
	  return x;
  }
  public int getY(){
	  return y;
  }
  public Color getColor(){
	  return color;
  }
}
