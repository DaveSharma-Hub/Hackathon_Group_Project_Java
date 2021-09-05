/**
@author Manjot Singh
@version 1.0
@since 1.0
*/
package edu.ucalgary.ensf409;

public class Filing extends Furniture{
	private boolean rails;
	private boolean drawers;
	private boolean cabinet;
	/**
	* Constructor for class Filing
	*/
	public Filing(String id, String type, int price, String manuID, 
	boolean rails, boolean drawers, boolean cabinet){
		super(id, type, price, manuID);
		this.rails = rails;
		this.drawers = drawers;
		this.cabinet = cabinet;
	}
	/**
	* Getter
	*/
	public boolean getRails (){
		return this.rails;
	}
	/**
	* Getter
	*/
	public boolean getDrawers(){
		return this.drawers;
	}
	/**
	* Getter
	*/
	public boolean getCabinet(){
		return this.cabinet;
	}
	/**
	* Setter
	*/
	public void setRails(boolean rails){
		this.rails = rails;
	}
	/**
	* Setter
	*/
	public void setDrawers(boolean drawers){
		this.drawers = drawers;
	}
	/**
	* Setter
	*/
	public void setCabinet(boolean cabinet){
		this.cabinet = cabinet;
	}
}