/**
@author Manjot Singh
@version 1.2
@since 1.0
*/
package edu.ucalgary.ensf409;

import java.io.*;
import java.util.ArrayList;

public class OrderForm{
	ArrayList<Furniture> orderID = null;
	int price = 0;
	String type = null;
	String object = null;
	int quantity = 0;
	/**
	* Constructor for class OrderForm
	*/
	public OrderForm(ArrayList<Furniture> orderID, int price, String type, int quantity, String object){
		this.orderID = orderID;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
		this.object = object;
	}
	/**
	* Method for class OrderForm, which creates and writes a Order Form to file OrderForm.txt
	*/
	public void writeOrderForm(){
		PrintWriter order;
		try {
			order = new PrintWriter("OrderForm.txt");
			order.flush();
			
			order.print("Furniture Order Form");
			order.println();
			order.println("Faculty Name:");
			order.println("Contact:");
			order.println("Date:");
			order.println();
			order.print("Original Request: " + this.type + " " + this.object + ", " + this.quantity);
			order.println();
			order.println("Items Ordered");
			for(int i = 0; i < orderID.size() - 1; i++){
				order.println("ID: " + orderID.get(i));
			}
			order.println();
			order.print("Total Price: " + this.price);
			
			order.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}