import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator {
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
			// set action listeners for buttons
			button.addActionListener(this);
			// define a custom short action command for the button
			button.setActionCommand(button.getText());
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			if (Character.isDigit(action.charAt(0))) {
				if (res.getText() != "") {
					n2 = Integer.parseInt(res.getText());
					res.setText(action);
					r = operation(n1, n2, op);
					res.setText(String.valueOf(r));
				} else {
					res.setText(action);
				}

			} else {
				if (res.getText() != "") n1 = Integer.parseInt(res.getText());		
				op = action.charAt(0);
				res.setText("");
			}
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
		displayField.setText("");
		Backend back = new Backend();
		back.res = displayField;
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
		windowContent.add("East", opl);
		opl.setLayout(new GridLayout(4, 3));
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
		// Finnaly, display the window
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}