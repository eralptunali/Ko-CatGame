package ghosts;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Ash extends JPanel implements Drawable {
	private ImageIcon i = new ImageIcon("src/images/ghost1.png");
	private int ashx;
	private int ashy;
	private int adirection;
	public Ash(int ashx, int ashy,int adirection) {
		// TODO Auto-generated constructor stub

		this.ashx=ashx;
		this.ashy=ashy;
		this.adirection=adirection;
	}
	
	public int getAdirection() {
		return adirection;
	}

	public void setAdirection(int adirection) {
		this.adirection = adirection;
	}

	public int getAshx() {
		return ashx;
	}

	public void setAshx(int ashx) {
		this.ashx = ashx;
	}

	public int getAshy() {
		return ashy;
	}

	public void setAshy(int ashy) {
		this.ashy = ashy;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(i.getImage(),ashx,ashy,null);
		this.setSize(71, 71);
	}

	@Override
	public void doAction(int x) {
		// TODO Auto-generated method stub
		if(x==1) {
			this.setAshx(this.getAshx()+20);
		}		
		if(x==-1) {
			this.setAshx(this.getAshx()-20);
		}
	}



	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}

}
