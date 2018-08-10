package pl.recrutimentTask.database;

import org.junit.Test;

public class SmallItemTest {

	@Test(expected=NullPointerException.class)
	public void testConstructorsBarcodeNullCheck(){
		new SmallItem(null, 3f, "test");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorsPriceNullCheck(){
		new SmallItem(new char[]{'t','e','s','t'}, null, "test");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorsNameNullCheck(){
		new SmallItem(new char[]{'t','e','s','t'}, 3f, null);
	}
}
