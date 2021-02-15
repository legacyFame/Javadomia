import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
    //Declaration of all calculator's components.
    JPanel windowContent;
    JTextField displayField;
    JButton numbuttons[];
    JButton opbuttons[];

    //Constructor creates the components in memory and adds the to the frame using combination of Borderlayout.
    Calculator() {
        windowContent= new JPanel();
        numbuttons = new JButton[10];
        opbuttons = new JButton[6];
    // Set the layout manager for this panel
        windowContent.setLayout(new BorderLayout());

    //Display
        displayField = new JTextField(30);
        windowContent.add("North",displayField);
       
    //Panel for nos
        JPanel npl = new JPanel();
        windowContent.add("East",npl);
        npl.setLayout(new GridLayout(4,3));
        for(int i = 0; i < 10; i++) {
                numbuttons[i] = new JButton(String.valueOf(i));
                npl.add(numbuttons[i]);
            }
    //Panel for operations
        JPanel opl = new JPanel();
        windowContent.add("West",opl);
        opl.setLayout(new GridLayout(4,3));
        char op[] = {'+','-','*','/','%','='};
        for(int i = 0; i < op.length; i++) {
            opbuttons[i]=new JButton(String.valueOf(op[i]));
            opl.add(opbuttons[i]);
        }

   
    //Create the frame and set its content pane
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
    //set the size of the window to be big enough to accomodate all controls.
        frame.pack();
    //Finnaly, display the window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();}}   