package pl.recrutimentTask.pointOfSale.bill;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.recrutimentTask.database.SmallItem;

public class ScannedBillTest {
	
	private ScannedBill bill = new ScannedBill();
	
	@Before
	public void setUp(){
		bill.addItem(new SmallItem(new char[]{'b','b','b','a'}, 13.0f, "ba"));
		bill.addItem(new SmallItem(new char[]{'b','b','b','b'}, 53.0f, "ba"));
		bill.addItem(new SmallItem(new char[]{'b','b','b','c'}, 23.0f, "ba"));
		bill.addItem(new SmallItem(new char[]{'b','b','b','d'}, 3.0f, "ba"));
	}
	
	@Test
	public void testPriceSumming(){
		assertEquals(bill.getSummedPrice(),92f,0f);
	}
}
