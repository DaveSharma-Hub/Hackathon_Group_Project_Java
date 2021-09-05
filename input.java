/**
 * 
 * @author Jaron Baldazo 
 * @version 1.0
 * @since 1.0
 *
 */
package edu.ucalgary.ensf409;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class input implements ActionListener{
	private static JLabel furnitureLabel;		//label for furniture name
	private static JLabel typeLabel;			//label for material type
	private static JLabel numberLabel;			//label for number of furnitures
	private static JButton button;				//button to get cheapest options
	private static JFrame frame;				//frame for GUI
	private static JPanel panel;				//panel for GUI
	private static JFrame errorFrame;
	private static JPanel errorPanel;
	private static JLabel errorLabel;
//	private static JTextField furnitureField;	//text field for furniture name
//	private static JTextField typeField;		//text field for material type
	private static JTextField numberField;		//text field for number of furnitures
	private static JComboBox <String> furnitureBox;
	private static JComboBox <String> typeBox;
//	private boolean inputOn = true;
	private Main main;							
	
	/**
	 * main method displays GUI with multiple text fields and a button to retrieve cheapest option
	 * @param args
	 */
	public static void main (String [] args) {
		input test = new input();
		test.inputWindow();
//		System.out.println("test");
	}
	
	/**
	 * method inputWindow sets up GUI
	 */
	public void inputWindow() {
		frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(400, 200);
		frame.add(panel);
		
		panel.setLayout(null);
		
		furnitureLabel = new JLabel("Enter Furniture Category:");
		furnitureLabel.setBounds(20, 0, 150, 50);
		
		String [] furniture = new String [] {"chair", "desk", "filing", "lamp"};
		furnitureBox = new JComboBox<String>(furniture);
		furnitureBox.setBounds(170,15,150,20);
		
		ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (furnitureBox.getSelectedItem().equals("chair")) {
        			String [] type = new String [] {"task", "mesh", "kneeling", "executive", "ergonomic"};
        			typeBox.setModel(new DefaultComboBoxModel<String>(type));
//        			panel.remove(typeBox);
//        			typeBox = new JComboBox(type);
//        			typeBox.setBounds(170, 55, 150, 20);
//        			panel.add(typeBox);
    
        		}
        		else if (furnitureBox.getSelectedItem().equals("desk")) {
        			String [] type = new String [] {"traditional", "adjustable", "standing"};
        			typeBox.setModel(new DefaultComboBoxModel<String>(type));
//        			panel.remove(typeBox);
//        			typeBox = new JComboBox(type);
//        			typeBox.setBounds(170, 55, 150, 20);
//        			panel.add(typeBox);
        		}
        		else if (furnitureBox.getSelectedItem().equals("filing")) {
        			String [] type = new String [] {"small", "medium", "large"};
        			typeBox.setModel(new DefaultComboBoxModel<String>(type));
//        			panel.remove(typeBox);
//        			typeBox = new JComboBox(type);
//        			typeBox.setBounds(170, 55, 150, 20);
//        			panel.add(typeBox);
        		}
        		else if (furnitureBox.getSelectedItem().equals("lamp")) {
        			String [] type = new String [] {"desk", "swing arm", "study"};
        			typeBox.setModel(new DefaultComboBoxModel<String>(type));
//        			panel.remove(typeBox);
//        			typeBox = new JComboBox(type);
//        			typeBox.setBounds(170, 55, 150, 20);
//        			panel.add(typeBox);
        		}
            }  
        };
		furnitureBox.addActionListener(cbActionListener);
		
//		furnitureField = new JTextField();
//		furnitureField.setBounds(170, 15, 150, 20);
		
		panel.add(furnitureLabel);
//		panel.add(furnitureField);
		panel.add(furnitureBox);
		
		typeLabel = new JLabel("Enter Furniture Type:");
		typeLabel.setBounds(20, 40, 150, 50);
		
		String [] type = new String [] {"task", "mesh", "kneeling", "executive", "ergonomic"};
		typeBox = new JComboBox<String>(type);
		typeBox.setBounds(170, 55, 150, 20);
		panel.add(typeBox);
		
//		typeField = new JTextField();
//		typeField.setBounds(170, 55, 150, 20);
		
		panel.add(typeLabel);
//		panel.add(typeField);
		
		numberLabel = new JLabel("Enter Number of Items:");
		numberLabel.setBounds(20, 80, 150, 50);
		
		numberField = new JTextField();
		numberField.setBounds(170, 95, 150, 20);
		
		panel.add(numberLabel);
		panel.add(numberField);
		
		button = new JButton("Get Options!");
		button.setBounds(120,125,125,20);
		panel.add(button);
		
		button.addActionListener(new input());
	
	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

	@Override
	/**
	 * method actionPerformed puts inputs when the button is pressed into a string array 
	 * and passed on to ___________ method to retrieve cheapest option
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if (Integer.parseInt(numberField.getText()) < 1){
				getErrorPanel();
				return;
			}
		}
		catch (NumberFormatException ex) {
			getErrorPanel();
			return;
		}
		
//		String [] inputElements = new String [3];
//		inputElements [0] = (String) furnitureBox.getSelectedItem();
//		inputElements [1] = (String) typeBox.getSelectedItem();
//		inputElements [2] = numberField.getText();
		frame.dispose();
		main = new Main ((String) furnitureBox.getSelectedItem(),(String) typeBox.getSelectedItem(),Integer.parseInt(numberField.getText()));
		main.decodeInput();
		
//		
//		System.out.println(inputElements[0]);
//		System.out.println(inputElements[1]);
//		System.out.println(inputElements[2]);
	}
	
	/**
	 * method getErrorPanel displays user interface if number of items is invalid
	 */
	public void getErrorPanel() {
		errorFrame = new JFrame();
		errorPanel = new JPanel();
		
		try {
		URL url = new URL("https://media.tenor.com/images/0946b6b73cc8c73a0f090f7e60b04a8f/tenor.gif");
	    Icon icon = new ImageIcon(url);
	    JLabel label = new JLabel(icon);
	    label.setSize(1000,1000);
		
		errorFrame.setSize(200, 100);
		errorFrame.add(errorPanel);
		errorPanel.setLayout(null);
		
		errorLabel = new JLabel("Invalid number of items.");
		errorLabel.setBounds(25, 0, 200, 50);
		errorPanel.add(errorLabel);
		
		JFrame f = new JFrame("Animation");
		f.setSize(1000,1000);
	    f.getContentPane().add(label);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
		
		errorFrame.setVisible(true);
		}
		catch (Exception e) {
			
		}
		
	}
}
