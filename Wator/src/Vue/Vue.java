package Vue;

import java.awt.*;

import javax.swing.*;

import SMA.SMA;
/**
 * display of the view
 *
 */
@SuppressWarnings("serial")
public class Vue extends JFrame {
  public static BilleBoard billeBoard;
  
  public Vue(int rows, int cols){
	  setTitle("SMA - TP1, fait par Ashaeva Maria et Yao Yuan");
	  billeBoard=new BilleBoard(rows, cols);
	
	  Container contentPane=getContentPane();
	  contentPane.add(billeBoard);
	  billeBoard.setOpaque(true);
	  add(billeBoard);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  //billeBoard.setBackground(Color.yellow);
	  
	  setSize(1000,1000);
  }

  public static void main(String[] args){
	  Vue f=new Vue(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
	  f.setVisible(true);
	  
	  SMA s = new SMA(args[0], args[1], args[2]);
	  new Thread(s).start();

  }
}

