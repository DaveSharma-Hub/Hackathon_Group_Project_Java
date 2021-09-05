package edu.ucalgary.ensf409;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * 
 * @author Jaron Baldazo 
 * @version 2.0
 * @since 1.0
 *
 */
public class Main {
	
	private String furniture;
	private String type;
	private int number;
	private SQLConnection connection;
	private JFrame outputFrame;
	private JPanel outputPanel;
	private JLabel outputLabel;
	
	/**Constructor for Main class
	 * 
	 * @param furniture - furniture category
	 * @param type - type of furniture
	 * @param number - number of furniture
	 */
	public Main (String furniture, String type, int number) {
		this.furniture = furniture;
		this.type = type;
		this.number = number;
		connection = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
		connection.initializeConnection();
	}
	
	/**
	 * Works on the user input, uses the input and request items from database. Finds the cheapest combination to complete order. Creates order text file.
	 */
	public void decodeInput() {
		if (this.furniture.equals("chair")) {
			ArrayList<Chair> chair = connection.getAllChair(this.type);
			ArrayList<Furniture> used = new ArrayList<Furniture>();
			int cost = cheapestOption.cheapestOptionChair(chair, this.number, used);
			outputGUI(cost, chair, used);
			if (cost >= 0) {
				OrderForm form = new OrderForm (used, cost, this.type, this.number, this.furniture);
				form.writeOrderForm();
				connection.deleteFurniture(used);
			}
		}
		else if (this.furniture.equals("desk")){
			ArrayList<Desk> desk = connection.getAllDesk(this.type);
			ArrayList<Furniture> used = new ArrayList<Furniture>();
			int cost = cheapestOption.cheapestOptionDesk(desk, this.number, used);
			outputGUI(cost, desk, used);
			if (cost >= 0) {
				OrderForm form = new OrderForm (used, cost, this.type, this.number, this.furniture);
				form.writeOrderForm();
				connection.deleteFurniture(used);
			}			
		}
		else if (this.furniture.equals("filing")){
			ArrayList<Filing> filing = connection.getAllFiling(this.type);
			ArrayList<Furniture> used = new ArrayList<Furniture>();
			int cost = cheapestOption.cheapestOptionFiling(filing, this.number, used);
			outputGUI(cost, filing, used);
			if (cost >= 0) {
				OrderForm form = new OrderForm (used, cost, this.type, this.number, this.furniture);
				form.writeOrderForm();
				connection.deleteFurniture(used);
			}
		}
		else if (this.furniture.equals("lamp")){
			ArrayList<Lamp> lamp = connection.getAllLamp(this.type);
			ArrayList<Furniture> used = new ArrayList<Furniture>();
			int cost = cheapestOption.cheapestOptionLamp(lamp, this.number, used);
			outputGUI(cost, lamp, used);
			if (cost >= 0) {
				OrderForm form = new OrderForm (used, cost, this.type, this.number, this.furniture);
				form.writeOrderForm();
				connection.deleteFurniture(used);
			}
		}
		connection.close();
	}
	
	/**Creates the output gui
	 * 
	 * @param cost - cost of combination
	 * @param furs - list of furniture
	 * @param used - ordered furniture
	 */
	public void outputGUI(int cost, ArrayList<? extends Furniture> furs, ArrayList<Furniture> used) {
		if (cost < 0) {
			StringBuilder output = new StringBuilder();
			outputFrame = new JFrame();
			outputPanel = new JPanel();
			
			
			output.append("<html>");
			output.append("User Requested: " + type + " " + furniture + "<br/>");
			output.append("Quantity: " + this.number + "<br/>");
			output.append("Order failed, we recommend contacting manufacturers: " + "<br/>");
			
		
			System.out.println("User Requested: " + type + " " + furniture);
			System.out.println("Quantity: " + this.number);
			System.out.println("Order failed, we recommend contacting manufacturers");
			ArrayList <String> ids = new ArrayList <String>();
			
//			System.out.println(used.size());
		
			for (int i = 0; i < furs.size(); i++) {
				if (!ids.contains(furs.get(i).getManuID())) {
					ids.add(furs.get(i).getManuID());
				}
//				System.out.println(used.get(i).getManuID());
			}
			for (int i = 0; i < ids.size(); i++) {
				output.append(connection.getManuNames(ids.get(i)) + "<br/>");
				System.out.println(connection.getManuNames(ids.get(i)));
			}
			
			outputFrame.setSize(600, 300);
			outputFrame.add(outputPanel);
			
			outputPanel.setLayout(null);
			
			output.append("</html>");
			outputLabel = new JLabel(output.toString(), SwingConstants.CENTER);
			outputLabel.setBounds(0, -20, 500, 300);
			
			outputPanel.add(outputLabel);
			
			outputFrame.setVisible(true);
			outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		else {
			StringBuilder output = new StringBuilder();
			outputFrame = new JFrame();
			outputPanel = new JPanel();
			
			output.append("<html>");
			output.append("User Requested: " + type + " " + furniture + "<br/>");
			output.append("Quantity: " + this.number + "<br/>");
			
			
			
			System.out.println("User Requested: " + type + " " + furniture);
			System.out.println("Quantity: " + this.number);
			for(int i = 0; i < used.size(); i++){
				output.append("ID: " + used.get(i) + "<br/>");
				System.out.println("ID: " + used.get(i));
			}
			
			outputFrame.setSize(600, 300);
			outputFrame.add(outputPanel);
			
			outputPanel.setLayout(null);
			
			output.append("</html>");
			outputLabel = new JLabel(output.toString(), SwingConstants.CENTER);
			outputLabel.setBounds(0, -20, 500, 300);
			
			outputPanel.add(outputLabel);
			
			outputFrame.setVisible(true);
			outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}