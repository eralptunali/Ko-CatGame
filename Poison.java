package foods;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.Drawable;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Poison extends JPanel implements Drawable{
	
	int age;
	int pxc;
	int pyc;
	int psize=20;
	public int getPsize() {
		return psize;
	}
	public void setPsize(int psize) {
		this.psize = psize;
	}
	public Poison(int age,int pxc,int pyc,int psize){
		this.age=age;
		this.pxc=pxc;
		this.pyc=pyc;
		this.psize=psize;
	}
	public int getPxc() {
		return pxc;
	}

	public void poisonager() {
		this.age++;
	}
	public void setPxc(int pxc) {
		this.pxc = pxc;
	}


	public int getPyc() {
		return pyc;
	}


	public void setPyc(int pyc) {
		this.pyc = pyc;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void draw(Graphics g) {
		if(this.age<100) {
			g.setColor(Color.YELLOW);		
			g.fillRect(pxc, pyc, psize, psize);	
		}else {
			g.setColor(Color.RED);
			g.fillRect(pxc, pyc, psize, psize);	
		}
	
	}
	@Override
	public void doAction(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		// this.setPsize(this.getPsize()+1); // You can comment out this to grow poison forever
		 
		if(psize<70) {
			this.setPsize(this.getPsize()+1);
		}else {
			this.setPsize(this.getPsize());
		}
	}
	

}
