/**
@author Manjot Singh
@version 1.0
@since 1.0
*/
package edu.ucalgary.ensf409;

public class Desk extends Furniture{
	private boolean legs;
	private boolean top;
	private boolean drawer;
	/**
	* Constructor for class Desk
	*/
	public Desk(String id, String type, int price, String manuID, 
	boolean legs, boolean top, boolean drawer){
		super(id, type, price, manuID);
		this.legs = legs;
		this.top = top;
		this.drawer = drawer;
	}
	
	/**
	* Getter
	*/
	public boolean getLegs(){
		return this.legs;
	}
	/**
	* Getter
	*/
	public boolean getDrawer(){
		return this.drawer;
	}
	/**
	* Getter
	*/
	public boolean getTop(){
		return this.top;
	}
	/**
	* Setter
	*/
	public void setLegs(boolean legs){
		this.legs = legs;
	}
	/**
	* Setter
	*/
	public void setDrawer(boolean drawer){
		this.drawer = drawer;
	}
	/**
	* Setter
	*/
	public void setTop(boolean top){
		this.top = top;
	}
}