
/**
 * 
 * @author Hiro
 *
 *         (E) Graphics Programming: 13) Write a Java program that works as a
 *         simple calculator. Arrange Buttons for digits and the + - * %
 *         operations properly. Add a text field to display the result. Handle
 *         any possible exceptions like divide by zero. Use Java Swing.
 *         
 *          ** 14)
 *         Write a Java program that simulates a traffic light. The program lets
 *         the user select one of three lights: red, yellow, or green. When a
 *         radio button is selected, the light is turned on, and only one light
 *         can be on at a time. No light is on when the program starts. 
 *         
 *         ** 15)
 *         Write a Java program to display all records from a table using Java
 *         Database Connectivity (JDBC).
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab5 extends JFrame implements ActionListener{
	

	class CalcFunc extends JFrame {
		int sum(int num1, int num2) {
			return num1 + num2;
		}

		int mod(int num1, int num2) {
			return num1 % num2;
		}

		int subtract(int num1, int num2) {
			return num1 - num2;
		}

		int multiply(int num1, int num2) {
			return num1 * num2;
		}

		int divide(int num1, int num2) {
			return num1 / num2;
		}
	}

	public SetActionCommandForJButton(JButton button) {

		//set action listeners for buttons
		button.addActionListener(this);

		// define a custom short action command for the button
		button.setActionCommand(button.getText());

		// add button to frame
		add(button);

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("Geeks")) {
			System.out.println("Button pressed!");
		}
	}
//https://examples.javacodegeeks.com/desktop-java/swing/jbutton/set-action-command-for-jbutton/
	class Calculator extends CalcFunc implements KeyListener { // doesn't support multiple extending @ moment.
		JLabel output = new JLabel();
		Calculator() {
			setTitle("Calculator");
			setSize(200, 150);
			setLocationRelativeTo(null);

			setLayout(new FlowLayout());
			JTextField inputBar = new JTextField(250);
			add(inputBar);

			JButton sum, sub, mod, mul, div;
			sum = new JButton("+");
			sub = new JButton("-");
			mul = new JButton("*");
			div = new JButton("/");
			mod = new JButton("%");

			JButton[] operButtons ;
			add(sum);
			add(sub);
			add(mul);
			add(div);
			add(mod);

			// JButton zero, one, two, three, four, five, six, seven, eight, nine;
			// zero = new JButton("0");
			// one = new JButton("1");
			// two = new JButton("2");
			// three = new JButton("3");
			// four = new JButton("4");
			// five = new JButton("5");
			// six = new JButton("6");
			// seven = new JButton("7");
			// eight = new JButton("8");
			// nine = new JButton("9");

			// add(zero);
			// add(one);
			// add(two);
			// add(three);
			// add(four);
			// add(five);
			// add(six);
			// add(seven);
			// add(eight);
			// add(nine);

			add(output);
		}

		public void keyPressed(KeyEvent ke) {
		}

		public void keyReleased(KeyEvent ke) {
		}
		public void keyTyped(KeyEvent ke) {
			output.setText(String.valueOf(ke.getKeyChar()));
		}

	}

	public static void main(String[] args) {

		Lab5 lab = new Lab5();
		Calculator calc = lab.new Calculator();
		calc.setVisible(true);

	}
}
