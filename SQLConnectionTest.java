package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.ArrayList;

import org.junit.Test;
/**
@author Angelo Gonzales 
@version 2.0

@since 1.0
 */
public class SQLConnectionTest {

	/**
	 * test chair getter of SQLConnection. Compares getter with another custom getter.
	 */
	@Test
	public void testGetAllChairMesh() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     ArrayList<? extends Furniture> result = myJDBC.getAllChair("Mesh");
	     
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     testSQL("chair", "Mesh", expected);
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test lamp getter of SQLConnection. Compares getter with another custom getter.
	 */
	@Test
	public void testGetAllLampDesk() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     ArrayList<? extends Furniture> result = myJDBC.getAllLamp("Desk");
	     
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     testSQL("lamp", "Desk", expected);
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test desk getter of SQLConnection. Compares getter with another custom getter.
	 */
	@Test
	public void testGetAllDeskTraditional() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     ArrayList<? extends Furniture> result = myJDBC.getAllDesk("Traditional");
	     
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     testSQL("desk", "Traditional", expected);
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test filing getter of SQLConnection. Compares getter with another custom getter.
	 */
	@Test
	public void testGetAllFilingLarge() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     ArrayList<? extends Furniture> result = myJDBC.getAllFiling("Large");
	     
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     testSQL("filing", "Large", expected);
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test furniture delete. adds 3 new rows with a custom add method and deletes using SQLConnection deleteFurniture.
	 */
	@Test
	public void testDeleteFurniture() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     ArrayList<Furniture> insert = new ArrayList<Furniture>();
	     insert.add(new Chair("C1234", "Task", 1, "002",false, false, false, false));
	     insert.add(new Chair("C1235", "Task", 1, "002",false, false, false, false));
	     insert.add(new Chair("C1236", "Task", 1, "002",false, false, false, false));
	     
	     ArrayList<? extends Furniture> expected = myJDBC.getAllChair("Task");
	     System.out.println("Before add");
	     for(Furniture fur : expected) {
	    	 System.out.println(fur);
	     }
	     
	     insertSQL("chair", "Task", "C1234");
	     insertSQL("chair", "Task", "C1235");
	     insertSQL("chair", "Task", "C1236");
	     
	     ArrayList<? extends Furniture> test = myJDBC.getAllChair("Task");
	     System.out.println("After add");
	     for(Furniture fur : test) {
	    	 System.out.println(fur);
	     }
	     
	     myJDBC.deleteFurniture(insert);
	     
	     
	     
	     
	     ArrayList<? extends Furniture> result = myJDBC.getAllChair("Task");
	     
	     System.out.println("After result");
	     for(Furniture fur : result) {
	    	 System.out.println(fur);
	     }
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test furniture delete. adds 1 new row with a custom add method and deletes using SQLConnection deleteChair().
	 */
	@Test
	public void testDeleteChair() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     
	     ArrayList<? extends Furniture> expected = myJDBC.getAllChair("Task");
	     System.out.println("Before add");
	     for(Furniture fur : expected) {
	    	 System.out.println(fur);
	     }
	     
	     insertSQL("chair", "Task", "C9999");
	     
	     ArrayList<? extends Furniture> test = myJDBC.getAllChair("Task");
	     System.out.println("After add");
	     for(Furniture fur : test) {
	    	 System.out.println(fur);
	     }
	     
	     myJDBC.deleteChair("C9999");
	     
	     ArrayList<? extends Furniture> result = myJDBC.getAllChair("Task");
	     
	     System.out.println("After result");
	     for(Furniture fur : result) {
	    	 System.out.println(fur);
	     }
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test furniture delete. adds 1 new row with a custom add method and deletes using SQLConnection deleteDesk().
	 */
	@Test
	public void testDeleteDesk() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     
	     ArrayList<? extends Furniture> expected = myJDBC.getAllDesk("Adjustable");
	     System.out.println("Before add");
	     for(Furniture fur : expected) {
	    	 System.out.println(fur);
	     }
	     
	     insertSQL("desk", "Adjustable", "D9999");
	     
	     ArrayList<? extends Furniture> test = myJDBC.getAllDesk("Adjustable");
	     System.out.println("After add");
	     for(Furniture fur : test) {
	    	 System.out.println(fur);
	     }
	     
	     myJDBC.deleteDesk("D9999");
	     
	     ArrayList<? extends Furniture> result = myJDBC.getAllDesk("Adjustable");
	     
	     System.out.println("After result");
	     for(Furniture fur : result) {
	    	 System.out.println(fur);
	     }
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test furniture delete. adds 1 new row with a custom add method and deletes using SQLConnection deleteFiling().
	 */
	@Test
	public void testDeleteFiling() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     
	     ArrayList<? extends Furniture> expected = myJDBC.getAllFiling("Large");
	     System.out.println("Before add");
	     for(Furniture fur : expected) {
	    	 System.out.println(fur);
	     }
	     
	     insertSQL("filing", "Large", "F999");
	     
	     ArrayList<? extends Furniture> test = myJDBC.getAllFiling("Large");
	     System.out.println("After add");
	     for(Furniture fur : test) {
	    	 System.out.println(fur);
	     }
	     
	     myJDBC.deleteFiling("F999");
	     
	     ArrayList<? extends Furniture> result = myJDBC.getAllFiling("Large");
	     
	     System.out.println("After result");
	     for(Furniture fur : result) {
	    	 System.out.println(fur);
	     }
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**
	 * test furniture delete. adds 1 new row with a custom add method and deletes using SQLConnection deleteLamp().
	 */
	@Test
	public void testDeleteLamp() {
		SQLConnection myJDBC = new SQLConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
	     myJDBC.initializeConnection();
	     
	     ArrayList<? extends Furniture> expected = myJDBC.getAllLamp("Study");
	     System.out.println("Before add");
	     for(Furniture fur : expected) {
	    	 System.out.println(fur);
	     }
	     
	     insertSQL("lamp", "Study", "L999");
	     
	     ArrayList<? extends Furniture> test = myJDBC.getAllLamp("Study");
	     System.out.println("After add");
	     for(Furniture fur : test) {
	    	 System.out.println(fur);
	     }
	     
	     myJDBC.deleteLamp("L999");
	     
	     ArrayList<? extends Furniture> result = myJDBC.getAllLamp("Study");
	     
	     System.out.println("After result");
	     for(Furniture fur : result) {
	    	 System.out.println(fur);
	     }
	     
	     boolean check = result.size() == expected.size();
	     for(int i = 0; i < result.size() && i < expected.size(); i++) {
	    	 System.out.println(result.get(i) +", "+expected.get(i));
	    	 if(!check) break;
	    	 if(!result.get(i).equals(result.get(i))) {
	    		check = false; 
	    	 }
	     }
	     
	     myJDBC.close();
	     
	     assertTrue(check);
	}
	
	/**Reads the inventory database for specified table and column and returns list of furniture returned by database.
	 * 
	 * @param table - table in inventory database
	 * @param type - type column of table
	 * @param list - list of furniture
	 */
	public void testSQL(String table, String type, ArrayList<? super Furniture> list) {
		Connection dbConnect;
		try {
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
			
			String query = "SELECT * FROM "+table+" WHERE Type = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, type);
    		
    		ResultSet results = statement.executeQuery();
    		
    		while(results.next()) {
    			if(table.equals("desk")){
    				list.add(new Desk(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
    					decodeYN(results.getString("Legs")), decodeYN(results.getString("Top")), decodeYN(results.getString("Drawer"))));
    			}
    			if(table.equals("chair")){
    				list.add(new Chair(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
        					decodeYN(results.getString("Legs")), decodeYN(results.getString("Arms")), decodeYN(results.getString("Seat")),
        					decodeYN(results.getString("Cushion"))));
    			}
    			if(table.equals("filing")){
    				list.add(new Filing(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
        					decodeYN(results.getString("Rails")), decodeYN(results.getString("Drawers")), decodeYN(results.getString("Cabinet"))));
    			}
    			if(table.equals("lamp")){
    				list.add(new Lamp(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
        					decodeYN(results.getString("Base")), decodeYN(results.getString("Bulb"))));
    			}
    			//chairs.add(new Chair(results.getString(")));
    		}
    		statement.close();
		}
		catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	/**Adds a row to a furniture table with a specified ID and Type.
	 * 
	 * @param table - table to add row
	 * @param type - type of furniture
	 * @param ID - ID of row to add to table
	 */
	public void insertSQL(String table, String type, String ID) {
		Connection dbConnect;
		try {
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory","scm","ensf409");
			
			String query = "INSERT INTO "+table+" (ID, Type) VALUES (?,?)";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, ID);
    		statement.setString(2, type);
    		
    		statement.executeUpdate();
    		
    		statement.close();
		}
		catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	/**Decodes Y/N to true/false
	 * 
	 * @param str - "Y" or "N"
	 * @return true for "Y", false otherwise
	 */
	private boolean decodeYN(String str) {
    	if(str.equals("Y")) {
    		return true;
    	}
    	else return false;
    }

}
