/**
@author Manjot Singh
@version 1.0
@since 1.0
*/
package edu.ucalgary.ensf409;

public class Lamp extends Furniture{
	private boolean base;
	private boolean bulb;
	/**
	* Constructor for class Lamp
	*/
	public Lamp(String id, String type, int price, String manuID, 
	boolean base, boolean bulb){
		super(id, type, price, manuID);
		this.base = base;
		this.bulb = bulb;
	}
	/**
	* Getter
	*/
	public boolean getBase(){
		return this.base;
	}
	/**
	* Getter
	*/
	public boolean getBulb(){
		return this.bulb;
	}
	/**
	* Setter
	*/
	public void setBase(boolean base){
		this.base = base;
	}
	/**
	* Setter
	*/
	public void setBulb(boolean bulb){
		this.bulb = bulb;
	}
	
}