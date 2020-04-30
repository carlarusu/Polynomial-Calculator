package ui;
import entities.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  The class represents the graphical user interface of the application.
 *  It facilitates user interaction by offering a text input system.
 *  @author Carla Rusu
 */

public class UserInterface extends JFrame{
	
	JTextField inputField1;
	JTextField inputField2;
	
	JTextField resultField1;
	JTextField resultField2;
	
	private Polynomial p1 =  new Polynomial();
	private Polynomial p2 =  new Polynomial();
	static boolean readText;
	
	/**User interface constructor
	 */
	public UserInterface() {
		initUi();
		readText = false;
	}
	
	/**Method initialises the user interface
	 */
	private void initUi() {
		
		this.setTitle("Polynomial Processing System");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		
		
		Font font1 = new Font("SansSerif", Font.PLAIN, 20);
		Font font2 = new Font("SansSerif", Font.PLAIN, 18);
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));	
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		
		resultField2 = new JTextField("Remainder (division only)");
		resultField2.setPreferredSize(new Dimension(400,30));
		resultField1 = new JTextField("Operation result");
		resultField1.setPreferredSize(new Dimension(400,30));
		inputField1 =  new JTextField("Write the first polynomial");
		inputField1.setPreferredSize(new Dimension(400,30));
		inputField2 =  new JTextField("Write the second polynomial");
		inputField2.setPreferredSize(new Dimension(400,30));
		resultField2.setFont(font2);
		resultField1.setFont(font2);
		inputField2.setFont(font2);
		inputField1.setFont(font2);
		
		JLabel opLabel = new JLabel("The derivative and integral will be done on the first polynomial.");
		opLabel.setFont(font2);
		
		
		JPanel inputPanel1 = new JPanel();
		inputPanel1.setLayout(new FlowLayout(0, 20, 20));
		JPanel inputPanel2 = new JPanel();
		inputPanel2.setLayout(new FlowLayout(0, 20, 10));
		JLabel inputLabel1 = new JLabel("<html><p>First Polynomial&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></html>");
		inputLabel1.setFont(font2);
		JLabel inputLabel2 = new JLabel("<html><p>Second polynomial :</p></html>");
		inputLabel2.setFont(font2);
		
		inputPanel1.add(inputLabel1);
		inputPanel1.add(inputField1);
		inputPanel2.add(inputLabel2);
		inputPanel2.add(inputField2);
		
		
		JPanel resultPanel1 = new JPanel();
		resultPanel1.setLayout(new FlowLayout(0, 20, 10));
		JPanel resultPanel2 = new JPanel();
		resultPanel2.setLayout(new FlowLayout(0, 20, 10));
		JLabel resultLabel1 = new JLabel("<html><p>Result&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></html>");
		resultLabel1.setFont(font2);
		JLabel resultLabel2 = new JLabel("<html><p>Remainder&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></html>");
		resultLabel2.setFont(font2);
		
		resultPanel1.add(resultLabel1);
		resultPanel1.add(resultField1);
		resultPanel2.add(resultLabel2);
		resultPanel2.add(resultField2);
		
		
		panel2.add(inputPanel1);
		panel2.add(inputPanel2);
		panel2.add(resultPanel1);
		panel2.add(resultPanel2);
		panel2.add(opLabel);
		
		
		JButton subtract = new JButton("<html><p>Subtract</p></html>");
		JButton add = new JButton("<html><p>Add</p></html>");
		JButton divide = new JButton("<html><p>Divide</p></html>");
		JButton multiply = new JButton("<html><p>Multiply</p></html>");
		JButton integrate =	new JButton("<html><p>Integrate</p></html>");
		JButton differentiate = new JButton("<html><p>Differentiate</p></html>");
		
		subtract.setFont(font1);
		add.setFont(font1);
		divide.setFont(font1);
		multiply.setFont(font1);
		integrate.setFont(font1);
		differentiate.setFont(font1);
		
		subtract.setMargin(new Insets(3, 20, 3, 20));
		add.setMargin(new Insets(3, 20, 3, 20));
		divide.setMargin(new Insets(3, 20, 3, 20));
		multiply.setMargin(new Insets(3, 20, 3, 20));
		integrate.setMargin(new Insets(3, 20, 3, 20));
		differentiate.setMargin(new Insets(3, 20, 3, 20));
		
		subtract.addActionListener(new OnClick(subtract));
		add.addActionListener(new OnClick(add));
		divide.addActionListener(new OnClick(divide));
		multiply.addActionListener(new OnClick(multiply));
		integrate.addActionListener(new OnClick(integrate));
		differentiate.addActionListener(new OnClick(differentiate));
		
		inputField1.addFocusListener(new SelClick(inputField1));
		inputField2.addFocusListener(new SelClick(inputField2));
		
		panel3.add( Box.createRigidArea(new Dimension(0,20)) );
		panel3.add(subtract);
		panel3.add( Box.createRigidArea(new Dimension(0,30)) );
		panel3.add(add);
		panel3.add( Box.createRigidArea(new Dimension(0,30)) );
		panel3.add(divide);
		panel3.add( Box.createRigidArea(new Dimension(0,30)) );
		panel3.add(multiply);
		panel3.add( Box.createRigidArea(new Dimension(0,30)) );
		panel3.add(integrate);
		panel3.add( Box.createRigidArea(new Dimension(0,30)) );
		panel3.add(differentiate);
		panel3.add( Box.createRigidArea(new Dimension(0,20)) );
		
		
		panel1.add(panel2);
		panel1.add(panel3);
		this.setContentPane(panel1);
		this.setVisible(true);
	}
	
	private class SelClick implements FocusListener{
		JTextField text;
		
		/**Constructor
		 * @param text
		 */
		private SelClick(JTextField text) {
			this.text = text;
		}
		
		/**Method to select the text of the object
		 */
		public void focusGained(FocusEvent arg0) {
			text.selectAll();
		}

		public void focusLost(FocusEvent arg0) {			
		}
		
	}
	
	private class OnClick implements ActionListener{

		String text;
		
		/**Constructor
		 * @param button. Represents the button that was clicked.
		 */
		OnClick(JButton button){
			text = button.getText();
		}
		
		/**Implementation of actionPerformed.
		 */
		public void actionPerformed(ActionEvent arg0) {
			if(!readText) {
				if (text.equals("Integrate") || text.equals("Differentiate")) {
					if(validate(inputField1)){
						parseInput(p1, inputField1);
						readText = true;
					}else {
						JOptionPane.showMessageDialog(UserInterface.this, "Invalid input. Should have the form: anx^n + ... + a2x^2 + a1x^1 + a0x^0, where ai=0..n is an integer.", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}else {
					if(validate(inputField1) && validate(inputField2)){
						parseInput(p1, inputField1);
						parseInput(p2, inputField2);
						readText = true;
					}else {
						JOptionPane.showMessageDialog(UserInterface.this, "Invalid input. Should have the form: anx^n + ... + a2x^2 + a1x^1 + a0x^0, where ai=0..n is an integer.", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				String result = "";
				String remainder = "No remainder for this operation"; 
				switch(text) {
					case "<html><p>Subtract</p></html>":
	    				result = p1.subtract(p2).toString();
	    				resultField1.setText(result);
	    				resultField2.setText(remainder);
	    				break;
					case "<html><p>Add</p></html>":
						result = p1.addition(p2).toString();
						resultField1.setText(result);
						resultField2.setText(remainder);
						break;
	    			case "<html><p>Multiply</p></html>":
	    				result = p1.multiply(p2).toString();
	    				resultField1.setText(result);
	    				resultField2.setText(remainder);
	    				break;
	    			case "<html><p>Divide</p></html>":
	    				Polynomial[] p3 = p1.divide(p2);
	    				result = p3[0].toString();
	    				remainder = p3[1].toString();
	    				resultField1.setText(result);
	    				resultField2.setText(remainder);
	    				break;
	    			case "<html><p>Integrate</p></html>":
	    				result = p1.integrate().toString();
	    				resultField1.setText(result);
	    				resultField2.setText(remainder);
	    				break;
	    			case "<html><p>Differentiate</p></html>":
	    				result = p1.diff().toString();
	    				resultField1.setText(result);
	    				resultField2.setText(remainder);
	    				break;
				}
				
			}
			p1 = new Polynomial();
			p2 = new Polynomial();
			readText = false;
		}
	}
	
	/**Method used to parse and convert the input
	 * @param p => the polynomial to be created
	 * @param input => the String representing the polynomial
	 */
	private void parseInput(Polynomial p, JTextField input) {
		String text = input.getText().replaceAll("\\s", "").replaceAll("-", "\\+-");
		// after replace effect: "+-2x^2+3x^1+6"
		String[] text1 = text.split("\\+");
		// textSplit will contain: {-2x^2, 3x^1, 6}
		for (String i : text1)
		{
			int coef = 1; 
			int deg = 0;
			// optional + or - sign
			// optional 0-9... etc.
			if (i.matches("[-]?[0-9]*([xX](\\^?[0-9]*)?)?") && !i.equals("")) {
				String[]  text2 = i.split("[xX]\\^|[xX]");
				//text2 == "" or "-"
				if (text2.length > 0)
					if(text2[0].equals("-")) {
						coef = -1;
					}else if (!text2[0].equals("")) {
						coef = Integer.parseInt(text2[0]);
					}else { 
						coef = 1;
					}
				if (text2.length > 1) {
					deg = Integer.parseInt(text2[1]);	
				}else if (i.matches(".*[xX].*")) {
					deg = 1;
				}else {
					deg = 0;
				}
				IntMonomial mono = new IntMonomial(coef, deg);
				p.addMonomial(mono);
			}else if (!i.equals("")){
				JOptionPane.showMessageDialog(UserInterface.this, "Invalid input. Should have the form: anx^n + ... + a2x^2 + a1x^1 + a0x^0, where ai=0..n is an integer.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	/**Initial validation of input. Checks for consistency.
	 * @param input => String that represents the polynomial 
	 * @return boolean => true if consistent with necessary form, false otherwise
	 */
	private boolean validate(JTextField input) {
		if(input.getText().matches("(.*)[0-9xX^ +-](.*)") || input.getText() == "")
    		return true;
    	else 
    		return false;
	}
	
	/**Main method used to instantiate UI
	 * @param args
	 */
	static public void main(String[] args) {
		UserInterface ui = new UserInterface();
	}
}
