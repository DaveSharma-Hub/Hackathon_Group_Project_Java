package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
@author Angelo Gonzales 

@version 1.0

@since 1.0
 */
public class CheapestOptionTest {

	/**
	 * Test cheapestOptionChair(). Has two options for creating a chair.
	 */
	@Test
	public void testCheapestOptionChair() {
		ArrayList<Chair> insert = new ArrayList<Chair>();
	     insert.add(new Chair("C1234", "Task", 20, "002",true, false, true, true));
	     insert.add(new Chair("C1235", "Task", 30, "002",true, true, true, false));
	     insert.add(new Chair("C1236", "Task", 500, "002",false, true, false, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionChair(insert, 1, result);
	     
	     int expPrice = 50;
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     expected.add(insert.get(0));
	     expected.add(insert.get(1));
	     
	     assertTrue((price == expPrice) && (result.equals(expected)));
	}
	
	/**
	 * Test cheapestOptionChair2(). Has no options for creating 2 chairs.
	 */
	@Test
	public void testCheapestOptionChair2() {
		ArrayList<Chair> insert = new ArrayList<Chair>();
	     insert.add(new Chair("C1234", "Task", 20, "002",true, false, true, true));
	     insert.add(new Chair("C1235", "Task", 30, "002",true, true, true, false));
	     insert.add(new Chair("C1236", "Task", 500, "002",false, true, false, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionChair(insert, 2, result);
	     
	     int expPrice = -1;
	     
	     assertTrue((price == expPrice));   
	}



	/**
	 * Test cheapestOptionDesk(). Has two options for creating a desk.
	 */
	@Test
	public void testCheapestOptionDesk() {
		ArrayList<Desk> insert = new ArrayList<Desk>();
	     insert.add(new Desk("C1234", "Task", 20, "002",true, false, true));
	     insert.add(new Desk("C1235", "Task", 30, "002",true, true, false));
	     insert.add(new Desk("C1236", "Task", 500, "002",false, true, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionDesk(insert, 1, result);
	     
	     int expPrice = 50;
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     expected.add(insert.get(0));
	     expected.add(insert.get(1));
	     
	     assertTrue((price == expPrice) && (result.equals(expected)));
	}

	/**
	 * Test cheapestOptionDesk2(). Has no options for creating 2 desks.
	 */
	@Test
	public void testCheapestOptionDesk2() {
		ArrayList<Desk> insert = new ArrayList<Desk>();
	     insert.add(new Desk("C1234", "Task", 20, "002",true, false, true));
	     insert.add(new Desk("C1235", "Task", 30, "002",true, true, false));
	     insert.add(new Desk("C1236", "Task", 500, "002",false, true, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionDesk(insert, 2, result);
	     
	     int expPrice = -1;
	     
	     
	     assertTrue((price == expPrice));
	}
	

	
	/**
	 * Test cheapestOptionFiling(). Has two options for creating a filing.
	 */
	@Test
	public void testCheapestOptionFiling() {
		ArrayList<Filing> insert = new ArrayList<Filing>();
	     insert.add(new Filing("C1234", "Task", 20, "002",true, true, false));
	     insert.add(new Filing("C1235", "Task", 30, "002",false, true, true));
	     insert.add(new Filing("C1236", "Task", 500, "002",false, false, true));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionFiling(insert, 1, result);
	     
	     int expPrice = 50;
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     expected.add(insert.get(0));
	     expected.add(insert.get(1));
	     
	     assertTrue((price == expPrice) && (result.equals(expected)));
	}

	/**
	 * Test cheapestOptionFiling2(). Has no options for creating 2 filings.
	 */
	@Test
	public void testCheapestOptionFiling2() {
		ArrayList<Filing> insert = new ArrayList<Filing>();
	     insert.add(new Filing("C1234", "Task", 20, "002",true, true, false));
	     insert.add(new Filing("C1235", "Task", 30, "002",false, true, true));
	     insert.add(new Filing("C1236", "Task", 500, "002",false, false, true));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionFiling(insert, 2, result);
	     
	     int expPrice = -1;
	     
	     assertTrue((price == expPrice));
	}
	
	/**
	 * Test cheapestOptionLamp(). Has two options for creating a lamp.
	 */
	@Test
	public void testCheapestOptionLamp() {
		ArrayList<Lamp> insert = new ArrayList<Lamp>();
	     insert.add(new Lamp("C1234", "Task", 20, "002", true, false));
	     insert.add(new Lamp("C1235", "Task", 30, "002", false, true));
	     insert.add(new Lamp("C1236", "Task", 500, "002",true, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionLamp(insert, 1, result);
	     
	     int expPrice = 50;
	     ArrayList<Furniture> expected = new ArrayList<Furniture>();
	     expected.add(insert.get(0));
	     expected.add(insert.get(1));
	     
	     assertTrue((price == expPrice) && (result.equals(expected)));
	}

	/**
	 * Test cheapestOptionLamp(). Has no options for creating 2 lamps.
	 */
	@Test
	public void testCheapestOptionLamp2() {
		ArrayList<Lamp> insert = new ArrayList<Lamp>();
	     insert.add(new Lamp("C1234", "Task", 20, "002", true, false));
	     insert.add(new Lamp("C1235", "Task", 30, "002", false, true));
	     insert.add(new Lamp("C1236", "Task", 500, "002",true, false));
	     
	     ArrayList<Furniture> result = new ArrayList<Furniture>();
	     int price = cheapestOption.cheapestOptionLamp(insert, 2, result);
	     
	     int expPrice = -1;
	     
	     assertTrue((price == expPrice));
	}
}
