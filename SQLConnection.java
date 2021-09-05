package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
/**
@author Angelo Gonzales 
@version 1.0

@since 1.0
 */
public class SQLConnection {

	public final String DBURL; //store the database url information
	public final String USERNAME; //store the user's account username
	public final String PASSWORD; //store the user's account password

	private Connection dbConnect;
	private ResultSet results;

	/**Initialize data fields needed to connect to database
	 * 
	 * @param dburl
	 * @param username
	 * @param password
	 */
	public SQLConnection(String dburl, String username, String password) {
		this.DBURL = dburl;
		this.USERNAME = username;
		this.PASSWORD = password;
	}

	/**
	 * @return url of database
	 */
	public String getDburl() {
		return DBURL;
	}



	/**
	 * @return username of user
	 */
	public String getUsername() {
		return USERNAME;
	}



	/**
	 * @return password of user
	 */
	public String getPassword() {
		return PASSWORD;
	}



	/**
	 * Initialize a connection to the database specified by the constructor using the user specified.
	 */
	public void initializeConnection() {
		try {
			dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		}
		catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	/**Closes current connection and result set.
     * 
     */
    public void close() {
    	try {
    		if(results != null){
    			results.close();
    		}
    		if(dbConnect != null) {
    			dbConnect.close();
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    /**Decodes Y/N to True/False
     * 
     * @param str - "Y" for true, false otherwise
     * @return true or false 
     */
    private boolean decodeYN(String str) {
    	if(str == null) {
    		return false;
    	}
    	if(str.equals("Y")) {
    		return true;
    	}
    	else return false;
    }
    
    /**Get all rows from chair table of with a specified value for Type column
     * 
     * @param type - type in Type column
     * @return Array List of chair with type
     */
    public ArrayList<Chair> getAllChair(String type) {
    	//boolean  exist = false;
    	ArrayList<Chair> chairs = new ArrayList<Chair>();
    	try {
    		String query = "SELECT * FROM chair WHERE Type = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, type);
    		
    		results = statement.executeQuery();
    		
    		while(results.next()) {

    			chairs.add(new Chair(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
    					decodeYN(results.getString("Legs")), decodeYN(results.getString("Arms")), decodeYN(results.getString("Seat")),
    					decodeYN(results.getString("Cushion"))));

    			//chairs.add(new Chair(results.getString(")));
    		}
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return chairs;

    }
    
    /**Get all rows from desk table of with a specified value for Type column
     * 
     * @param type - type in Type column
     * @return Array List of desk with type
     */
    public ArrayList<Desk> getAllDesk(String type) {
    	//boolean  exist = false;
    	ArrayList<Desk> desks = new ArrayList<Desk>();
    	try {
    		String query = "SELECT * FROM desk WHERE Type = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, type);
    		
    		results = statement.executeQuery();
    		
    		while(results.next()) {

    			desks.add(new Desk(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
    					decodeYN(results.getString("Legs")), decodeYN(results.getString("Top")), decodeYN(results.getString("Drawer"))));

    			//chairs.add(new Chair(results.getString(")));
    		}
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return desks;

    }
    
    /**Get all rows from filing table of with a specified value for Type column
     * 
     * @param type - type in Type column
     * @return Array List of filing with type
     */
    public ArrayList<Filing> getAllFiling(String type) {
    	//boolean  exist = false;
    	ArrayList<Filing> filing = new ArrayList<Filing>();
    	try {
    		String query = "SELECT * FROM filing WHERE Type = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, type);
    		
    		results = statement.executeQuery();
    		
    		while(results.next()) {

    			filing.add(new Filing(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
    					decodeYN(results.getString("Rails")), decodeYN(results.getString("Drawers")), decodeYN(results.getString("Cabinet"))));

    			//chairs.add(new Chair(results.getString(")));
    		}
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return filing;

    }
    
    /**Get all rows from lamp table of with a specified value for Type column
     * 
     * @param type - type in Type column
     * @return Array List of lamp with type
     */
    public ArrayList<Lamp> getAllLamp(String type) {
    	//boolean  exist = false;
    	ArrayList<Lamp> lamp = new ArrayList<Lamp>();
    	try {
    		String query = "SELECT * FROM lamp WHERE Type = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		
    		statement.setString(1, type);
    		
    		results = statement.executeQuery();
    		
    		while(results.next()) {

    			lamp.add(new Lamp(results.getString("ID"), results.getString("Type"), results.getInt("Price"), results.getString("ManuID"),
    					decodeYN(results.getString("Base")), decodeYN(results.getString("Bulb"))));

    			//chairs.add(new Chair(results.getString(")));
    		}
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return lamp;

    }
    
    /**Deletes an ArrayList of furniture from the database
     * @param furniture - List of furniture to delete
     */
    public void deleteFurniture(ArrayList<Furniture> furniture) {
    	for(Furniture fur : furniture) {
    		if(fur instanceof Chair) {
    			deleteChair(fur.getID());
    		}
    		if(fur instanceof Desk) {
    			deleteDesk(fur.getID());
    		}
    		if(fur instanceof Filing) {
    			deleteFiling(fur.getID());
    		}
    		if(fur instanceof Lamp) {
    			deleteLamp(fur.getID());
    		}
    	}
    }
    
    /**Deletes a row from the chair table
     * @param id - ID column of chair
     */
    public void deleteChair(String id) {
    	try {
    		String query = "DELETE FROM chair WHERE ID = ?";
    		PreparedStatement statement = dbConnect.prepareStatement(query);
    		
    		statement.setString(1, id);
    		//System.out.println(statement);
    		
    		statement.executeUpdate();
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    /**Deletes a row from the desk table
     * @param id - ID column of desk
     */
    public void deleteDesk(String id) {
    	try {
    		String query = "DELETE FROM desk WHERE ID = ?";
    		PreparedStatement statement = dbConnect.prepareStatement(query);
    		
    		statement.setString(1, id);
    		//System.out.println(statement);
    		
    		statement.executeUpdate();
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    /**Deletes a row from the filing table
     * @param id - ID column of filing
     */
    public void deleteFiling(String id) {
    	try {
    		String query = "DELETE FROM filing WHERE ID = ?";
    		PreparedStatement statement = dbConnect.prepareStatement(query);
    		
    		statement.setString(1, id);
    		//System.out.println(statement);
    		
    		statement.executeUpdate();
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    /**Deletes a row from the lamp table
     * @param id - ID column of lamp
     */
    public void deleteLamp(String id) {
    	try {
    		String query = "DELETE FROM lamp WHERE ID = ?";
    		PreparedStatement statement = dbConnect.prepareStatement(query);
    		
    		statement.setString(1, id);
    		//System.out.println(statement);
    		
    		statement.executeUpdate();
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public String getManuNames (String id) {
    	try {
    		String query = "SELECT * FROM manufacturer WHERE ManuID = ?";
    		PreparedStatement statement =  dbConnect.prepareStatement(query);
    		statement.setString(1, id);
    		results = statement.executeQuery();
    		if (results.next()) {
    			return results.getString("Name");
    		}
    		statement.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
