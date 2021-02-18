
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
/*
 * 
 */
/* Excess 
 * 
 * public void SetKeylistener(JTextField res) {
				res.addKeyListener(this);
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}

			@Override
			public void keyTyped(KeyEvent ke) {
				res.setText(String.valueOf(ke));
			} 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Lab5 {
	static void printf(String str) {
		System.out.println(str);
		return;
	}

	class Calculator extends JFrame {
		private static final long serialVersionUID = 1L;

		class CalcFunc {
			int operation(int a, int b, char op) {
				switch (op) {
				case '+':
					return a + b;
				case '-':
					return a - b;
				case '%':
					return a % b;
				case '*':
					return a * b;
				default:
					return 0;
				}
			}
		}

		class Backend extends CalcFunc implements ActionListener {
			int n1, n2, r;
			JTextField res;
			char op;

			public void SetActionCommandForJButton(JButton button) {
				button.addActionListener(this);
				button.setActionCommand(button.getText());
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				String action = ae.getActionCommand();
				if (Character.isDigit(action.charAt(0))) {
					if (res.getText().length() > 0) {
						n1 = Integer.parseInt(res.getText());
						n2 = Integer.parseInt(action);
						res.setText(action);
						if (op != ' ') {
							r = operation(n1, n2, op);
//							printf(String.valueOf(r));
							res.setText(String.valueOf(r));
							op = ' ';
						}
					} else
						res.setText(action);

				} else
					op = action.charAt(0);

			}

			Backend(JTextField displayField) {
				res = displayField;
			}
		}

		// Declaration of all calculator's components.
		JPanel windowContent;
		JTextField displayField;
		JButton numbuttons[];
		JButton opbuttons[];

		// Constructor creates the components in memory and adds the to the frame using
		// combination of Borderlayout.
		Calculator() {
			// Display
			displayField = new JTextField(30);
			Backend back = new Backend(displayField);
			windowContent = new JPanel();
			numbuttons = new JButton[10];
			opbuttons = new JButton[6];
			// Set the layout manager for this panel
			windowContent.setLayout(new BorderLayout());
			windowContent.add("North", displayField);
			// Panel for nos
			JPanel npl = new JPanel();
			windowContent.add("West", npl);
			npl.setLayout(new GridLayout(4, 3));
			for (int i = 0; i < 10; i++) {
				numbuttons[i] = new JButton(String.valueOf(i));
				npl.add(numbuttons[i]);
				back.SetActionCommandForJButton(numbuttons[i]);
			}
			// Panel for operations
			JPanel opl = new JPanel();
			windowContent.add("Center", opl);
			opl.setLayout(new GridLayout(4, 1));
			char op[] = { '+', '-', '*', '%' };
			for (int i = 0; i < op.length; i++) {
				opbuttons[i] = new JButton(String.valueOf(op[i]));
				opl.add(opbuttons[i]);
				back.SetActionCommandForJButton(opbuttons[i]);
			}

			// Create the frame and set its content pane
			JFrame frame = new JFrame("Calculator");
			frame.setContentPane(windowContent);
			// set the size of the window to be big enough to accomodate all controls.
			frame.pack();
			// Finaly, display the window
			frame.setVisible(true);
		}
	}

	class Traffic extends JFrame {

		class Backend implements ActionListener {
			JButton cur, btn;
			JButton[] lights;
			void colorset(JButton btn, char color) {
				System.out.println(color);
				switch (color) {
				case 'R':
					btn.setBackground(Color.red);
				case 'Y':
					btn.setBackground(Color.yellow);
				case 'G':
					btn.setBackground(Color.green);
				default: return;
				}
			}

			public void SetActionCommandForJButton(JButton button) {
				button.addActionListener(this);
				button.setActionCommand(button.getText());
				button.setOpaque(true);
				button.setBackground(Color.black);
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				String action = ae.getActionCommand();
				if (cur != null)
					cur.setBackground(Color.black);
				for (int i = 0; i < 3; i++) {
					if (action == lights[i].getText()) {
						cur = lights[i];
						colorset(cur,action.charAt(0));
						return;
					}
				}

			}
			
			Backend(JButton[] lights){
				this.lights = lights;			
				for(JButton i: lights) {
					this.SetActionCommandForJButton(i);
				}
			}

		}
        JPanel windowContent;
        JButton[] lights;
        char[] light; 
		Traffic() {
			JPanel windowContent = new JPanel();
			windowContent.setLayout(new GridLayout(3,1));
			char light[] = { 'R', 'Y', 'G' };
			JButton[] lights = new JButton[3];
			for (int i = 0; i < light.length; i++) {
				lights[i] = new JButton(String.valueOf(light[i]));
				windowContent.add(lights[i]);
			}
			Backend back = new Backend(lights);
			JFrame frame = new JFrame("Traffic");
			frame.setContentPane(windowContent);
			frame.pack();
			frame.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Lab5 lab = new Lab5();
		Calculator calc = lab.new Calculator();
		Traffic trf = lab.new Traffic();
	}
}
