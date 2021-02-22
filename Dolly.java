package ghosts;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Dolly implements Drawable{

	private ImageIcon i = new ImageIcon("src/images/ghost2.png");
	private int dollyx;
	private int dollyy;
	private int ddirection=1;

	public Dolly(int dollyx, int dollyy,int ddirection) {
		// TODO Auto-generated constructor stub

		this.dollyx=dollyx;
		this.dollyy=dollyy;
		this.ddirection=ddirection;
	}

	public int getDdirection() {
		return ddirection;
	}

	public void setDdirection(int ddirection) {
		this.ddirection = ddirection;
	}

	public int getDollyx() {
		return dollyx;
	}

	public void setDollyx(int dollyx) {
		this.dollyx = dollyx;
	}

	public int getDollyy() {
		return dollyy;
	}

	public void setDollyy(int dollyy) {
		this.dollyy = dollyy;
	}

	public void paint(Graphics g) {
		this.draw(g);
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(i.getImage(),dollyx,dollyy,null);
	}


	@Override
	public void doAction(int x) {
		// TODO Auto-generated method stub
		if(x==1) {
			this.setDollyy(this.getDollyy()+20);	
		}		
		if(x==-1) {
			this.setDollyy(this.getDollyy()-20);
		}

	}


	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}

}
