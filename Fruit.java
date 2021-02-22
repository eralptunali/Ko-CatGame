package foods;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Fruit extends JPanel implements Drawable {

	int fage;
	int fxc;
	int fyc;
	int fsize = 20;
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	public Fruit(int fage,int fxc,int fyc,int fsize){
		this.fage=fage;
		this.fxc=fxc;
		this.fyc=fyc;
		this.fsize=fsize;
	}
	public int getFxc() {
		return fxc;
	}
	public void fruitager() {
		this.fage++;
	}

	public void setFxc(int pxc) {
		this.fxc = pxc;
	}


	public int getFyc() {
		return fyc;
	}


	public void setFyc(int pyc) {
		this.fyc = pyc;
	}


	public int getAge() {
		return fage;
	}


	public void setAge(int age) {
		this.fage = age;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(this.fage<50) {
			g.setColor(Color.BLUE);	
			g.fillOval(fxc, fyc, fsize, fsize);
		}else{
			g.setColor(Color.GREEN);	
			g.fillOval(fxc, fyc, fsize, fsize);
		}
		
	}


	@Override
	public void doAction(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		if(fsize<60) {
			this.setFsize(this.getFsize()+1);
		}else {
			this.setFsize(this.getFsize());
		}
	}

}
