package player;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class KocCat extends JPanel implements Drawable{
	private int score;
	private int xAxis;
	private int yAxis;
	private String imagePath;
	private boolean isAlive;
	private int catdirection;
	
	
	public KocCat(int score, int xAxis, int yAxis, String imagePath, boolean isAlive,int catdirection) {
		super();
		setCatdirection(catdirection);
		setScore(score);
		setxAxis(xAxis);
		setyAxis(yAxis);
		setImagePath(imagePath);
		setAlive(isAlive);
	}
	

	public int getCatdirection() {
		return catdirection;
	}


	public void setCatdirection(int catdirection) {
		this.catdirection = catdirection;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		if(imagePath == null) {
			JOptionPane.showMessageDialog(null, "Invalid string.");
		}else if(imagePath.length()==0) {
			JOptionPane.showMessageDialog(null, "Empty String.");
		}else {
			this.imagePath = imagePath;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public void draw(Graphics g) {
		ImageIcon i = new ImageIcon(imagePath);
		g.drawImage(i.getImage(),xAxis,yAxis,null);	
	}

	public void doAction(int x) {
		if(x==0) {
			this.setxAxis(this.getxAxis()+20);
		}
		if(x==1) {
			this.setxAxis(this.getxAxis()-20);	
		}
		if(x==2) {
			this.setyAxis(this.getyAxis()-20);
		}
		if(x==3) {
			this.setyAxis(this.getyAxis()+20);
		}
		if(x==4) {
			this.setxAxis(this.getxAxis());
			this.setyAxis(this.getyAxis());
		}
	}


	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}
}
