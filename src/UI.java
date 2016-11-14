import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.InputMismatchException;

public class UI extends JFrame{
	
	private JPanel inputPane;
	
	private JButton rulerButton;
	private JButton binaryButton;
	private JButton stairButton;
	private JTextField binaryTextField;
	private JTextField stairsTextField;
	private JTextField msgTextField;
	
	private JPanel contentPane;
	
	public UI() {
		
		super("Fun with Recursion");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Default font for the inter userface
		Font defaultFont = new Font("Arial", Font.BOLD, 12);
		
		// Input related fields for adding/updating a character
		inputPane = new JPanel();		
		inputPane.setBounds(10, 32, 450, 300);
		contentPane.add(inputPane);
		inputPane.setLayout(null);

		// Set labels and fields
		JLabel lblConvertBinary = new JLabel("<html>Enter a number in the text field to "
				+ "convert it to binary.</html>");
		lblConvertBinary.setFont(defaultFont);
		lblConvertBinary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConvertBinary.setBounds(20, 161, 300, 14);
		inputPane.add(lblConvertBinary);
				
		JLabel lblStairs = new JLabel("<html>You are standing at the bottom of "
				+ "a long flight of stairs and you begin to wonder whether you "
				+ "should skip a stair, or just take it one step at a time.  "
				+ "Upon thinking further, you realize there must be a way to figure "
				+ "out how many different combinations of big steps and small steps "
				+ "there are to climb the stairs.  There is, simply type the number of "
				+ "stairs in the textbox, and the program will tell you how many "
				+ "combinations exist to climb the flight of stairs.</html>");
		lblStairs.setFont(defaultFont);
		lblStairs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStairs.setBounds(20, 0, 430, 100);
		inputPane.add(lblStairs);
		

		stairsTextField = new JTextField();
		stairsTextField.setFont(defaultFont);
		stairsTextField.setBounds(150, 111, 50, 28);
		inputPane.add(stairsTextField);
		stairsTextField.setColumns(25);
		
		binaryTextField = new JTextField();
		binaryTextField.setFont(defaultFont);
		binaryTextField.setBounds(150, 191, 50, 28);
		inputPane.add(binaryTextField);
		binaryTextField.setColumns(25);		

		msgTextField = new JTextField();
		msgTextField.setFont(defaultFont);
		msgTextField.setBounds(20, 235, 350, 20);
		msgTextField.setEditable(false);
		inputPane.add(msgTextField);
		msgTextField.setColumns(25);	
		
		
		stairButton = new JButton("Calculate");
		// Event listener for the Add button click
		stairButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!stairsTextField.getText().isEmpty()) {	
					countWays(stairsTextField.getText());
				} else {
					msgTextField.setText("Enter an integer into the text field.");
				}

			}
		});
		stairButton.setFont(defaultFont);
		stairButton.setBounds(20, 111, 90, 28);
		inputPane.add(stairButton);

		
		binaryButton = new JButton("Convert");
		// Event trigger to convert to binary
		binaryButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!binaryTextField.getText().isEmpty()) {	
					convertToBinary(binaryTextField.getText());
				} else {
					msgTextField.setText("Enter an integer into the text field.");
				}
			}
		});
		binaryButton.setFont(defaultFont);
		binaryButton.setBounds(20, 191, 90, 28);
		inputPane.add(binaryButton);
		
		
		rulerButton = new JButton("Display Ruler");
		// Event trigger for the Search button click
		rulerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				// Search for a character in the list
				displayRuler();
			}
		});
		rulerButton.setFont(defaultFont);
		rulerButton.setBounds(20, 271, 120, 28);
		inputPane.add(rulerButton);
	}
	
	public void countWays(String sNumStairs) {
		int numStairs;
		int manyWays = 0;
		try {
			numStairs = Integer.parseInt(sNumStairs);
			manyWays = recursiveFunctions.countWays(numStairs);
		} catch (NumberFormatException e){
			msgTextField.setText("Enter an integer");	
		}
		msgTextField.setText("There are " + manyWays + " different ways to climb the stairs.");
	}
	
	public void convertToBinary(String numString) {
		int number;
		String binaryNumber = null;
		try {
			number = Integer.parseInt(numString);
			binaryNumber = recursiveFunctions.printInBinary(number);
		} catch (NumberFormatException e){
			msgTextField.setText("Enter an integer");
		}
		msgTextField.setText(numString + " in decimal is " + binaryNumber + " in binary.");
	}
	
	public void displayRuler() {
		rulerCreator rule = new rulerCreator();
		rule.setVisible(true);
		rule.init();
	}
}
