/**
@author Manjot Singh
@version 1.0
@since 1.0
*/
package edu.ucalgary.ensf409;

public class Furniture{
	private String id;
	private String type;
	private int price;
	private String manuID;
	/**
	* Constructor for class Furniture
	*/
	public Furniture(String id, String type, int price, String manuID){
		this.id = id;
		this.type = type;
		this.price = price;
		this.manuID = manuID;
	}
	/**
	* Getter
	*/
	public String getID(){
		return this.id;
	}
	/**
	* Getter
	*/
	public String getType(){
		return this.type;
	}
	/**
	* Getter
	*/
	public int getPrice(){
		return this.price;
	}
	/**
	* Getter
	*/
	public String getManuID(){
		return this.manuID;
	}
	/**
	* Setter
	*/
	public void setID(String id){
		this.id = id;
	}
	/**
	* Setter
	*/
	public void setType(String type){
		this.type = type;
	}
	/**
	* Setter
	*/
	public void setPrice(int price){
		this.price = price;
	}
	/**
	* Setter
	*/
	public void setManuID(String manuID){
		this.manuID = manuID;
	}
	
	@Override
	public String toString() {
		return id;
	}
}