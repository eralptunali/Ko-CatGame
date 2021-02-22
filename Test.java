package Test;



import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import game.GameBoard;
/*THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME:ERALP TUNALI*/
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		ImageIcon opener1 = new ImageIcon("src/images/ghost1.png");
		JOptionPane.showMessageDialog(null,"---Welcome to Koç Cat v1.0 by Eralp Tunalı 59687---\n"+"INSTRUCTIONS\n"
				+ "1)You are expected to change the movement direction of the KoçCat which is initially going right and try to survive.\n"
				+ "2)Eating the poisons(squares) will cause you negative score multiplied by its age.\n"
				+ "3)Eating the foods(circles) will cause you positive score multiplied by its age.\n"
				+ "4)Hitting any of the ghosts will make you die instantly.\n"
				+ "Good Luck!",
				"KoçCat v1.0",JOptionPane.INFORMATION_MESSAGE,opener1);
		String foodAmount = JOptionPane.showInputDialog("Type the food amount you want to see: ");
		String poisonAmount = JOptionPane.showInputDialog("Type the poison amount you want to see: ");
		String ghostAmount = JOptionPane.showInputDialog("Type the ghost amount you want to see: ");
		if(Integer.parseInt(foodAmount) < 0 ||Integer.parseInt(poisonAmount)< 0||Integer.parseInt(ghostAmount)< 0) {
			JOptionPane.showMessageDialog(null, "Invalid inputs, Game wont be started. . .");
			throw new IllegalArgumentException("Invalid inputs");
		}else {
			int foodNumber = Integer.parseInt(foodAmount);
			int poisonNumber = Integer.parseInt(poisonAmount);
			int ghostNumber = Integer.parseInt(ghostAmount);
			GameBoard game = new GameBoard(foodNumber,poisonNumber,ghostNumber);
		}
		
	}

}
