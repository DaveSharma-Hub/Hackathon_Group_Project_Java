/**
@author Manjot Singh
@version 1.0
@since 1.0
*/
package edu.ucalgary.ensf409;

public class Chair extends Furniture{
	private boolean legs;
	private boolean arms;
	private boolean seat;
	private boolean cushion;
	/**
	* Constructor for class Chair
	*/
	public Chair(String id, String type, int price, String manuID, 
	boolean legs, boolean arms, boolean seat, boolean cushion){
		super(id, type, price, manuID);
		this.legs = legs;
		this.arms = arms;
		this.seat = seat;
		this.cushion = cushion;
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
	public boolean getArms(){
		return this.arms;
	}
	/**
	* Getter
	*/
	public boolean getSeat(){
		return this.seat;
	}
	/**
	* Getter
	*/
	public boolean getCushion(){
		return this.cushion;
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
	public void setArms(boolean arms){
		this.arms = arms;
	}
	/**
	* Setter
	*/
	public void setSeat(boolean seat){
		this.seat = seat;
	}
	/**
	* Setter
	*/
	public void setCushion(boolean cushion){
		this.cushion = cushion;
	}
		
}