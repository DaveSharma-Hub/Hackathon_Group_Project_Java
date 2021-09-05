/**
@author Dave Sharma 
@version 2.0
@since 1.0
*/
package edu.ucalgary.ensf409;
import java.util.ArrayList;

/*
public class cheapestOption that determines the optimal solution using 4 different methods for each of the furniture types
*/
public class cheapestOption{

/*
cheapestOptionChair determines the optimal solution with a price return and using the arraylist as a pass-by-reference, input the chair(s) into used 
@args - ArrayList<Chair> chair, int number and ArrayList<Furniture> used, number is the number of chairs desired
@return - price as an integer	
*/
	public static int cheapestOptionChair(ArrayList<Chair> chair, int number, ArrayList<Furniture> used) {
		ArrayList<Chair> legs = new ArrayList<Chair>();
		ArrayList<Chair> arms = new ArrayList<Chair>();
		ArrayList<Chair> seat = new ArrayList<Chair>();
		ArrayList<Chair> cushion = new ArrayList<Chair>();
		for(Chair ch : chair) {
			if(ch.getArms()) {
				arms.add(ch);
			}
			if(ch.getLegs()) {
				legs.add(ch);
			}
			if(ch.getSeat()) {
				seat.add(ch);
			}
			if(ch.getCushion()) {
				cushion.add(ch);
			}
		}
		if(legs.size() < number || arms.size() < number || seat.size() < number || cushion.size() < number) {
			return -1;
		}
		
		while(number > 0) {
			
			int index1 = 0;
			int index2 = 0;
			int index3 = 0;
			int index4 = 0;
			int cost = Integer.MAX_VALUE;
			for(int i = 0; i < legs.size(); i++) {
				for(int j = 0; j < arms.size(); j++) {
					for(int m = 0; m < seat.size(); m++) {
						for(int k = 0; k < cushion.size(); k++) {
							int temp = legs.get(i).getPrice();
							if(!legs.get(i).equals(arms.get(j))) {
								temp += arms.get(j).getPrice();
							}
							if(!legs.get(i).equals(seat.get(m)) && !arms.get(j).equals(seat.get(m))) {
								temp += seat.get(m).getPrice();
							}
							if(!legs.get(i).equals(cushion.get(k)) && !arms.get(j).equals(cushion.get(k)) && !seat.get(m).equals(cushion.get(k))) {
								temp += cushion.get(k).getPrice();
							}
							
							if(temp < cost) {
								index1 = i;
								index2 = j;
								index3 = m;
								index4 = k;
								cost = temp;
							}
						}
					}
				}
			}
			if(!used.contains(legs.get(index1))) {
				used.add(legs.get(index1));
			}
			if(!used.contains(arms.get(index2))) {
				used.add(arms.get(index2));
			}
			if(!used.contains(seat.get(index3))) {
				used.add(seat.get(index3));
			}
			if(!used.contains(cushion.get(index4))) {
				used.add(cushion.get(index4));
			}
			
			legs.remove(index1);
			arms.remove(index2);
			seat.remove(index3);
			cushion.remove(index4);
			//total += cost;
			number--;
		}
		int total = 0;
		for(Furniture ch : used) {
			total += ch.getPrice();
		}
		return total;
	}
	
/*
cheapestOptionDesk determines the optimal solution with a price return and using the arraylist as a pass-by-reference, input the desk(s) into used 
@args - ArrayList<Desk> desk, int number and ArrayList<Furniture> used, number is the number of desks desired
@return - price as an integer	
*/
	public static int cheapestOptionDesk(ArrayList<Desk> desk, int number, ArrayList<Furniture> used) {
		ArrayList<Desk> legs = new ArrayList<Desk>();
		ArrayList<Desk> top = new ArrayList<Desk>();
		ArrayList<Desk> drawer = new ArrayList<Desk>();
		
		for(Desk de : desk) {
			if(de.getLegs()) {
				legs.add(de);
			}
			if(de.getTop()) {
				top.add(de);
			}
			if(de.getDrawer()) {
				drawer.add(de);
			}
		}
		
		if(legs.size() < number || top.size() < number || drawer.size() < number) {
			return -1;
		}
		
		while(number > 0) {
			int index1 = 0;
			int index2 = 0;
			int index3 = 0;
			int cost = Integer.MAX_VALUE;
			for(int i = 0; i < legs.size(); i++) {
				for(int j = 0; j < top.size(); j++) {
					for(int m = 0; m < drawer.size(); m++) {
						int temp = legs.get(i).getPrice();
						if(!legs.get(i).equals(top.get(j))) {
							temp += top.get(j).getPrice();
						}
						if(!legs.get(i).equals(drawer.get(m)) && !top.get(j).equals(drawer.get(m))) {
							temp += drawer.get(m).getPrice();
						}
						if(temp < cost) {
							index1 = i;
							index2 = j;
							index3 = m;
							cost = temp;
						}
					}
				}
			}
			if(!used.contains(legs.get(index1))) {
				used.add(legs.get(index1));
			}
			if(!used.contains(top.get(index2))) {
				used.add(top.get(index2));
			}
			if(!used.contains(drawer.get(index3))) {
				used.add(drawer.get(index3));
			}
			legs.remove(index1);
			top.remove(index2);
			drawer.remove(index3);
			//total += cost;
			number--;
		}
		int total = 0;
		for(Furniture ch : used) {
			total += ch.getPrice();
		}
		return total;	
	}
/*
cheapestOptionFiling determines the optimal solution with a price return and using the arraylist as a pass-by-reference, input the filing(s) into used 
@args - ArrayList<Filing> filing, int number and ArrayList<Furniture> used, number is the number of filings desired
@return - price as an integer	
*/
	public static int cheapestOptionFiling (ArrayList<Filing> filing, int number, ArrayList<Furniture> used) {
		ArrayList<Filing> rails = new ArrayList<Filing>();
		ArrayList<Filing> drawers = new ArrayList<Filing>();
		ArrayList<Filing> cabinet = new ArrayList<Filing>();
		
		for(Filing fi : filing) {
			if(fi.getRails()) {
				rails.add(fi);
			}
			if(fi.getDrawers()) {
				drawers.add(fi);
			}
			if(fi.getCabinet()) {
				cabinet.add(fi);
			}
		}
		
		if(rails.size() < number || drawers.size() < number || cabinet.size() < number) {
			return -1;
		}
		
		while(number > 0) {
			int index1 = 0;
			int index2 = 0;
			int index3 = 0;
			int cost = Integer.MAX_VALUE;
			for(int i = 0; i < rails.size(); i++) {
				for(int j = 0; j < drawers.size(); j++) {
					for(int m = 0; m < cabinet.size(); m++) {
						int temp = rails.get(i).getPrice();
						if(!rails.get(i).equals(drawers.get(j))) {
							temp += drawers.get(j).getPrice();
						}
						if(!rails.get(i).equals(cabinet.get(m)) && !drawers.get(j).equals(cabinet.get(m))) {
							temp += cabinet.get(m).getPrice();
						}
						if(temp < cost) {
							index1 = i;
							index2 = j;
							index3 = m;
							cost = temp;
						}
					}
				}
			}
			if(!used.contains(rails.get(index1))) {
				used.add(rails.get(index1));
			}
			if(!used.contains(drawers.get(index2))) {
				used.add(drawers.get(index2));
			}
			if(!used.contains(cabinet.get(index3))) {
				used.add(cabinet.get(index3));
			}
			rails.remove(index1);
			drawers.remove(index2);
			cabinet.remove(index3);
			//total += cost;
			number--;
		}
		int total = 0;
		for(Furniture ch : used) {
			total += ch.getPrice();
		}
		return total;
		
		
	}

/*
cheapestOptionLamp determines the optimal solution with a price return and using the arraylist as a pass-by-reference, input the lamp(s) into used 
@args - ArrayList<Lamp> lamp, int number and ArrayList<Furniture> used, number is the number of lamps desired
@return - price as an integer	
*/
	public static int cheapestOptionLamp (ArrayList<Lamp> lamp, int number, ArrayList<Furniture> used) {
		ArrayList<Lamp> base = new ArrayList<Lamp>();
		ArrayList<Lamp> bulb = new ArrayList<Lamp>();

		
		for(Lamp la : lamp) {
			if(la.getBase()) {
				base.add(la);
			}
			if(la.getBulb()) {
				bulb.add(la);
			}
		}
		
		if(base.size() < number || bulb.size() < number) {
			return -1;
		}
		
		while(number > 0) {
			int index1 = 0;
			int index2 = 0;
			int cost = Integer.MAX_VALUE;
			for(int i = 0; i < base.size(); i++) {
				for(int j = 0; j < bulb.size(); j++) {
						int temp = base.get(i).getPrice();
						if(!base.get(i).equals(bulb.get(j))) {
							temp += bulb.get(j).getPrice();
						}
	
						if(temp < cost) {
							index1 = i;
							index2 = j;
							cost = temp;
						}
					}
			}
			if(!used.contains(base.get(index1))) {
				used.add(base.get(index1));
			}
			if(!used.contains(bulb.get(index2))) {
				used.add(bulb.get(index2));
			}
			base.remove(index1);
			bulb.remove(index2);
			//total += cost;
			number--;
		}
		int total = 0;
		for(Furniture ch : used) {
			total += ch.getPrice();
		}
		return total;
	}
	
	public static void main(String[] args) {
		SQLConnection connection = new SQLConnection("jdbc:mysql://localhost/inventory","jaron","ENSF409");
		connection.initializeConnection();
		ArrayList<Chair> chair = connection.getAllChair("Task");
		ArrayList<Desk> desk = connection.getAllDesk("Traditional");
//		for(Chair ch : chair) {
//			System.out.println(ch.getPrice());
//		}
		//cheapestOption cheap = new cheapestOption();
		
		ArrayList<Furniture> used = new ArrayList<Furniture>();
//		System.out.println(cheapestOption.cheapestOptionChair(chair, 2, used));
//		System.out.println(used);
		System.out.println(cheapestOption.cheapestOptionDesk(desk, 2, used));
		System.out.println(used);
		connection.close();
	}
}






