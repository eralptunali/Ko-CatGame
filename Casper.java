package ghosts;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Casper  implements Drawable {

	private ImageIcon i = new ImageIcon("src/images/ghost3.png");
	private int casperx;
	private int caspery;
	private int cdirection;
	public int getCasperx() {
		return casperx;
	}
	public void setCasperx(int casperx) {
		this.casperx = casperx;
	}
	public int getCaspery() {
		return caspery;
	}
	public void setCaspery(int caspery) {
		this.caspery = caspery;
	}
	public Casper(int casperx,int caspery,int cdirection) {

		this.casperx=casperx;
		this.caspery=caspery;
		this.cdirection=cdirection;
	}
	
	public int getCdirection() {
		return cdirection;
	}
	public void setCdirection(int cdirection) {
		this.cdirection = cdirection;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(i.getImage(),casperx,caspery,null);
	}
	@Override
	public void doAction(int x) {
		// TODO Auto-generated method stub
		if(x==1) {
			this.setCasperx(this.getCasperx()+20);
		}
		if(x==2) {
			this.setCaspery(this.getCaspery()+20);
		}
		if(x==3) {
			this.setCasperx(this.getCasperx()-20);
		}
		if(x==4) {
			this.setCaspery(this.getCaspery()-20);
		}
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}

}
