package game;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import foods.Fruit;
import foods.Poison;
import ghosts.Ash;
import ghosts.Casper;
import ghosts.Dolly;
import interfaces.Drawable;
import player.KocCat;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class GameBoard extends JPanel implements KeyListener {
	private ImageIcon closer = new ImageIcon("src/images/ghost3.png");
	private ImageIcon background = new ImageIcon("src/images/background.jpg");
	Random rgen = new Random();
	private JFrame f1 = new JFrame("KOÇCAT / ERALP TUNALI 59687");
	private KocCat c1 = new KocCat(0,290,290,"src/images/right.png",true,0);
	ArrayList<Drawable> tobedrawed = new ArrayList<Drawable>();	
	private Poison poison = new Poison(0,0,0,20);
	private Fruit  fruit = new Fruit(0,0,0,20);
	private JLabel score = new JLabel("Score: 0");
	private Casper casper = new Casper(0,0,1);
	private Ash ash = new Ash(0,0,1);
	private Dolly dolly = new Dolly(0,0,1);
	///////////////////////////////////////////////
	private ArrayList<Poison> poisons = new ArrayList<Poison>();
	private ArrayList<Fruit> fruits = new ArrayList<Fruit>();
	private ArrayList<Casper> caspers = new ArrayList<Casper>();
	private ArrayList<Dolly> dollys = new ArrayList<Dolly>();
	private ArrayList<Ash> ashs = new ArrayList<Ash>();
	//////////////////////////////////////////////
    int secondPassed = 0;
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
		
			secondPassed++;
			System.out.println("You have been playing this game till "+ secondPassed/10 + "seconds.");
			for(int i=0;i<fruits.size();i++) {
				fruits.get(i).fruitager();
				fruits.get(i).grow();
			}
			for(int i=0;i<poisons.size();i++) {
				poisons.get(i).poisonager();
				poisons.get(i).grow();
			}
			for(int i=0;i<dollys.size();i++) {
				dollys.get(i).doAction(dollys.get(i).getDdirection());
				if(dollys.get(i).getDollyy()<0) {
				dollys.get(i).setDdirection(1);
				}
				if(dollys.get(i).getDollyy()>600) {
				dollys.get(i).setDdirection(-1);	
				}
			}
			for(int i=0;i<ashs.size();i++) {
				ashs.get(i).doAction(ashs.get(i).getAdirection());
				if(ashs.get(i).getAshx()<0) {
				ashs.get(i).setAdirection(1);
				}
				if(ashs.get(i).getAshx()>630) {
				ashs.get(i).setAdirection(-1);	
				}
			}
			for(int i=0;i<caspers.size();i++) {	
				   if(caspers.get(i).getCasperx()>500 && caspers.get(i).getCdirection()==1) {
					   int[] xd = {2,3,4};
					   int random1 = rgen.nextInt(2);
					   caspers.get(i).setCdirection(xd[random1]);
				   }else if(caspers.get(i).getCasperx()<100&&caspers.get(i).getCdirection()==3) {
					   int[] xd1 = {2,4,1};
					   int random2 = rgen.nextInt(2);
					   caspers.get(i).setCdirection(xd1[random2]);
				   }else if(caspers.get(i).getCaspery()>500&&caspers.get(i).getCdirection()==2) {
					   int[] xd2 = {1,3,4};
					   int random3 = rgen.nextInt(2);
					   caspers.get(i).setCdirection(xd2[random3]);
				   }else if(caspers.get(i).getCaspery()<100&&caspers.get(i).getCdirection()==4) {
					   int[] xd3 = {3,1,2};
					   int random4 = rgen.nextInt(2);
					   caspers.get(i).setCdirection(xd3[random4]);
				   }else {
					   caspers.get(i).doAction(caspers.get(i).getCdirection());
				   }
			}
			if(c1.getxAxis()> 640 && c1.getCatdirection()==0) {
				c1.doAction(4);
			}else if(c1.getxAxis()<0 && c1.getCatdirection()==1){
				c1.doAction(4);
			}else if(c1.getyAxis()>600 && c1.getCatdirection()==3) {
				c1.doAction(4);
			}else if(c1.getyAxis()<0&&c1.getCatdirection()==2) {
				c1.doAction(4);
			}else {
				c1.doAction(c1.getCatdirection());
			}	
		}
	};	
	public void start() {
		myTimer.scheduleAtFixedRate(task,100,100);
	}
	
	public GameBoard(int foodAmount, int poisonAmount, int ghostAmount) {	
		int ghosting=0;
		this.start();
		setFocusable(true);
		addKeyListener(this);	
		///////////////////////////////////////////
		for(int i = 0 ; i< poisonAmount ; i++) {
			int pxc = rgen.nextInt(630);
			int pyc = rgen.nextInt(630);
			poison = new Poison(0,pxc,pyc,20);
			poisons.add(poison);
			tobedrawed.add(poison);
		}
		for(int i = 0 ; i< foodAmount ; i++) {
			int fxc = rgen.nextInt(630);
			int fyc = rgen.nextInt(630);
			fruit = new Fruit(0,fxc,fyc,20);
			fruits.add(fruit);
			tobedrawed.add(fruit);
		}
		for(int i=0;i<ghostAmount;i++) {
			int g0xc = rgen.nextInt(600);
			int g0yc = rgen.nextInt(600);
			casper = new Casper(g0xc,g0yc,1);
			caspers.add(casper);
			tobedrawed.add(casper);
			ghosting++;
			if(ghosting==ghostAmount) {
				break;
			}
			int g1xc = rgen.nextInt(600);
			int g1yc = rgen.nextInt(600);
			ash = new Ash(g1xc,g1yc,1);
			ashs.add(ash);
			tobedrawed.add(ash);
			ghosting++;
			if(ghosting==ghostAmount) {
				break;
			}
			int g2xc = rgen.nextInt(600);
			int g2yc = rgen.nextInt(600);
			dolly = new Dolly(g2xc,g2yc,1);
			dollys.add(dolly);
			tobedrawed.add(dolly);
			ghosting++;
			if(ghosting==ghostAmount) {
				break;
			}
		}
		tobedrawed.add(c1);
		f1.add(score,BorderLayout.SOUTH);
		f1.add(this);
		///////////////////////////////////////////
		f1.setSize (700, 700);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);	
		f1.setResizable(false);
		///////////////////////////////////////////
		while(c1.isAlive()) {	
			this.repaint();
			for(int i = 0 ; i < poisons.size() ; i++) {
				int randomxd = rgen.nextInt(630);
				int randomyd = rgen.nextInt(630);
				if(Math.abs(c1.getxAxis()-poisons.get(i).getPxc())<poisons.get(i).getPsize()	
				&& Math.abs(c1.getyAxis()-poisons.get(i).getPyc())<poisons.get(i).getPsize())
				{
					poisons.get(i).setPxc(randomxd);
					poisons.get(i).setPyc(randomyd);
					c1.setScore((c1.getScore()-((poisons.get(i).getAge())*10)/10));
					poisons.get(i).setAge(0);
					poisons.get(i).setPsize(20);
					score.setText("Score: " + c1.getScore());
				}
			}
			for(int i = 0 ; i < fruits.size() ; i++) {
				int randomxd1 = rgen.nextInt(630);
				int randomyd1 = rgen.nextInt(630);
				if(Math.abs(c1.getxAxis()-fruits.get(i).getFxc())<fruits.get(i).getFsize()+3
				&& Math.abs(c1.getyAxis()-fruits.get(i).getFyc())<fruits.get(i).getFsize()+3)
				{
					c1.setScore((c1.getScore()+((fruits.get(i).getAge())*5)/10));
					fruits.get(i).setFxc(randomxd1);
					fruits.get(i).setFyc(randomyd1);
					fruits.get(i).setAge(0);
					fruits.get(i).setFsize(20);
					score.setText("Score: " + c1.getScore());
				}
				if(fruits.get(i).getAge()>100) {
					fruits.get(i).setFxc(randomxd1);
					fruits.get(i).setFyc(randomyd1);
					fruits.get(i).setAge(0);
					fruits.get(i).setFsize(20);
				}
			}
			for(int i=0;i<ashs.size();i++) {
				if(Math.abs(c1.getxAxis()-ashs.get(i).getAshx())<40 && Math.abs(c1.getyAxis()-ashs.get(i).getAshy())<40) {
					c1.setAlive(false);
				}
			}
			for(int i=0;i<dollys.size();i++) {
				if(Math.abs(c1.getxAxis()-dollys.get(i).getDollyx())<40 && Math.abs(c1.getyAxis()-dollys.get(i).getDollyy())<40) {
					c1.setAlive(false);
				}
			}
			for(int i=0;i<caspers.size();i++) {
				if(Math.abs(c1.getxAxis()-caspers.get(i).getCasperx())<40 && Math.abs(c1.getyAxis()-caspers.get(i).getCaspery())<40) {
					c1.setAlive(false);
				}
			}		
			if(c1.getScore()<0) {
				c1.setAlive(false);
			}
		}
		if(!c1.isAlive()) {
			JOptionPane.showMessageDialog(null,"G A M E O V E R >:)\n"
					+ "You survived: " +secondPassed/10+" seconds." ,"GAMEOVER",JOptionPane.INFORMATION_MESSAGE,closer);
			f1.setVisible(false);
			f1.dispose();
			System.exit(0);
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			c1.setImagePath("src/images/right.png");
			c1.setCatdirection(0);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT ) {
			c1.setCatdirection(1);;
			c1.setImagePath("src/images/left.png");
		}else if(e.getKeyCode()==KeyEvent.VK_UP ) {
			c1.setCatdirection(2);
			c1.setImagePath("src/images/up.png");
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			c1.setCatdirection(3);
			c1.setImagePath("src/images/down.png");	
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(background.getImage(),0,0,null);
		for(Drawable obj : tobedrawed) {
			obj.draw(g);
		}
	}



	}


